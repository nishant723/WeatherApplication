package nishant.lab.weatherapplication.presentation.bottom_navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import nishant.lab.weatherapplication.R

@RequiresApi(Build.VERSION_CODES.O)
@Composable
 fun mainScreen(){
     val navController = rememberNavController()
    Scaffold(bottomBar = { BottomBar(navController = navController)}) {
        BottomNavGraph(navController = navController)
    }
 }

@Composable
fun BottomBar(navController: NavController){
    val screen = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.TimeLine,
        BottomBarScreen.DaysForecast
    )

    val navBackStackEntery by navController.currentBackStackEntryAsState()
    val currentDestination=navBackStackEntery?.destination
    BottomNavigation( backgroundColor = Color.White) {
        screen.forEach{screen->
            if (currentDestination != null) {
                AddItem(screen = screen, currentDestination = currentDestination, navController = navController as NavHostController)
            }
        }
        
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination,
    navController: NavHostController
){
   
 BottomNavigationItem(
     label = {
         Text(text = screen.tital)
     },
     icon = {
         Image(painter = painterResource(id = screen.icon), contentDescription = "")
     },
     selected = currentDestination.hierarchy?.any {
         it.route==screen.screen_route
     }==true,
     unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
     onClick = {
         navController.navigate(screen.screen_route)
     }
 )
}