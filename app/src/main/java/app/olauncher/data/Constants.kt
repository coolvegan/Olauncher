package app.olauncher.data

object Constants {

    object Key {
        const val FLAG = "flag"
        const val RENAME = "rename"
    }

    object DateTime {
        const val OFF = 0
        const val ON = 1
        const val DATE_ONLY = 2

        fun isTimeVisible(dateTimeVisibility: Int): Boolean {
            return dateTimeVisibility == ON
        }

        fun isDateVisible(dateTimeVisibility: Int): Boolean {
            return dateTimeVisibility == ON || dateTimeVisibility == DATE_ONLY
        }
    }

    object Weather {
        const val OFF = false
        const val ON = true

        fun isWeatherVisible(weatherVisibility: Boolean): Boolean {
            return weatherVisibility == ON
        }
    }

    object SwipeDownAction {
        const val SEARCH = 1
        const val NOTIFICATIONS = 2
    }

    object TextSize {
        const val ONE = 0.5f
        const val TWO = 0.75f
        const val THREE = 0.9f
        const val FOUR = 1f
        const val FIVE = 1.1f
        const val SIX = 1.25f
        const val SEVEN = 1.5f
    }

    const val WALL_TYPE_LIGHT = "light"
    const val WALL_TYPE_DARK = "dark"

//    const val THEME_MODE_DARK = 0
//    const val THEME_MODE_LIGHT = 1
//    const val THEME_MODE_SYSTEM = 2

    const val FLAG_LAUNCH_APP = 100
    const val FLAG_HIDDEN_APPS = 101

    const val FLAG_SET_HOME_APP_1 = 1
    const val FLAG_SET_HOME_APP_2 = 2
    const val FLAG_SET_HOME_APP_3 = 3
    const val FLAG_SET_HOME_APP_4 = 4
    const val FLAG_SET_HOME_APP_5 = 5
    const val FLAG_SET_HOME_APP_6 = 6
    const val FLAG_SET_HOME_APP_7 = 7
    const val FLAG_SET_HOME_APP_8 = 8

    const val FLAG_SET_SWIPE_LEFT_APP = 11
    const val FLAG_SET_SWIPE_RIGHT_APP = 12

    const val REQUEST_CODE_ENABLE_ADMIN = 666

    const val HINT_RATE_US = 30
    const val HINT_SHARE = 50

    const val TRIPLE_TAP_DELAY_MS = 300L
    const val LONG_PRESS_DELAY_MS = 500L

    const val URL_ABOUT_OLAUNCHER = "https://tanujnotes.notion.site/Olauncher-Minimal-AF-4843e398b05a455bb521b0665b26fbcd"
    const val URL_OLAUNCHER_PRIVACY = "https://tanujnotes.notion.site/Olauncher-Privacy-Policy-dd6ac5101ddd4b3da9d27057889d44ab"
    const val URL_DOUBLE_TAP = "https://tanujnotes.notion.site/Double-tap-to-lock-Olauncher-0f7fb103ec1f47d7a90cdfdcd7fb86ef"
    const val URL_OLAUNCHER_GITHUB = "https://www.github.com/tanujnotes/Olauncher"
    const val URL_OLAUNCHER_PLAY_STORE = "https://play.google.com/store/apps/details?id=app.olauncher"
    const val URL_PLAY_STORE_DEV = "https://play.google.com/store/apps/dev?id=7198807840081074933"
    const val URL_TWITTER_TANUJ = "https://twitter.com/tanujnotes"
    const val URL_INSTA_OLAUNCHER = "https://instagram.com/olauncherapp"
    const val URL_WALLPAPERS = "https://gist.githubusercontent.com/tanujnotes/bf400a269746c5c124a599af040dd82e/raw"
    const val URL_DEFAULT_DARK_WALLPAPER = "https://images.unsplash.com/photo-1512551980832-13df02babc9e"
    const val URL_DEFAULT_LIGHT_WALLPAPER = "https://images.unsplash.com/photo-1515549832467-8783363e19b6"
    const val URL_DUCK_SEARCH = "https://duck.co/?q="

    const val WALLPAPER_WORKER_NAME = "WALLPAPER_WORKER_NAME"
}