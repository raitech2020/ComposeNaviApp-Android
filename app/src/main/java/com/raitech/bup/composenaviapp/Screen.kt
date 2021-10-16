package com.raitech.bup.composenaviapp

const val DETAIL_ARGUMENT_KEY1 = "id"
const val DETAIL_ARGUMENT_KEY2 = "name"
const val BUP_ARGUMENT_ID = "id"
const val BUP_ARGUMENT_NAME = "name"

sealed class Screen(val route: String) {
    object Home : Screen(route = "home_screen")
    object Detail :
        Screen(route = "detail_screen/{$DETAIL_ARGUMENT_KEY1}/{$DETAIL_ARGUMENT_KEY2}") {
        fun passId(id: Int): String {
            // return "detail_screen/$id"
            return this.route.replace(
                oldValue = "{$DETAIL_ARGUMENT_KEY1}",
                newValue = id.toString()
            )
        }

        fun passIdAndName(id: Int, name: String): String {
            return "detail_screen/$id/$name"
        }
    }

    object Bup : Screen(route = "bup_screen?id={id}&name={name}") {
        fun passId(id: Int = 1): String {
            return "bup_screen?id=$id"
        }

        fun passIdAndName(
            id: Int = 10,
            name: String = "BupTech"
        ): String {
            return "bup_screen?id=$id&name=$name"
        }
    }
}
