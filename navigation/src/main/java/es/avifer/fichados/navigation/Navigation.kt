package es.avifer.fichados.navigation

import androidx.navigation.NavDirections

sealed class Navigation {
    data class ToDirection(val directions: NavDirections) : Navigation()
    object Back : Navigation()
}