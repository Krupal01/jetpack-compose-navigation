package com.example.jetpacknavigation.simple_navigation


sealed class NavigationRoutes(val routes : String){

    object Screen1 : NavigationRoutes(routes = "Screen1")

    object Screen2 : NavigationRoutes(routes = "Screen2/{$MSG_KEY}"){
        fun setArg(msg: String): String {
            return this.routes.replace(
                oldValue = "{$MSG_KEY}",
                newValue = msg
            )
        }

//         for multiple arg '/'
//        routes = "Screen2/{$MSG_KEY}/{$MSG_KEY}/{$MSG_KEY}"
    }

    object Screen3 : NavigationRoutes(routes = "Screen3?$SENDER_KEY={$SENDER_KEY}"){
        fun setArg(sender : String): String {
            return this.routes.replace(
                oldValue = "{$SENDER_KEY}",
                newValue = sender
            )
        }

//        for multiple arg '&'
//        routes = "Screen3?$SENDER_KEY={$SENDER_KEY}&$SENDER_KEY={$SENDER_KEY}&$SENDER_KEY={$SENDER_KEY}"
    }

    object Screen4 : NavigationRoutes(routes = "Screen4")
    object Screen5 : NavigationRoutes(routes = "Screen5")

    object ChildNavGraph : NavigationRoutes(routes = "ChildNavGraph")

}
