import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
}

kotlin {
    jvm("desktop") {
        jvmToolchain(11)
    }

    sourceSets["desktopMain"].dependencies {
        implementation(projects.sample.common)

        implementation(compose.desktop.currentOs)
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "com.mohamedrejeb.compose.dnd.sample"
            packageVersion = "1.0.0"
        }
    }
}
