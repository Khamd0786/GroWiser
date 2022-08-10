import org.gradle.api.artifacts.dsl.DependencyHandler

const val implementation = "implementation"
const val testImplementation = "testImplementation"
const val androidTestImplementation = "androidTestImplementation"
const val api = "api"
const val kapt = "kapt"


object Dependencies {
    private const val dagger = "com.google.dagger:dagger:2.38.1"
    private const val daggerCompiler = "com.google.dagger:dagger-compiler:2.38.1"

    private const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:2.3.5";
    private const val navigationUI = "androidx.navigation:navigation-ui-ktx:2.3.5";

    private const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2"


    private const val core = "androidx.core:core-ktx:1.7.0"
    private const val appCompat = "androidx.appcompat:appcompat:1.4.0"
    private const val material = "com.google.android.material:material:1.4.0"
    private const val jUnit = "junit:junit:4.13.2"
    private const val extJunit = "androidx.test.ext:junit:1.1.3"
    private const val espresso = "androidx.test.espresso:espresso-core:3.4.0"

    private const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0"
    private const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:2.4.0"
    private const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.0"

    private const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
    private const val gson = "com.squareup.retrofit2:converter-gson:2.9.0"

    private const val room = "androidx.room:room-ktx:2.4.0"
    private const val roomCompiler = "androidx.room:room-compiler:2.4.0"
    private const val roomPaging = "androidx.room:room-paging:2.4.0"

    private const val paging = "androidx.paging:paging-runtime:3.1.0"

    private const val timber = "com.jakewharton.timber:timber:5.0.1"

    fun applyDagger(handler: DependencyHandler) {
        handler.add(implementation, dagger)
        handler.add(kapt, daggerCompiler)
    }

    fun applyNavigationComponent(handler: DependencyHandler) {
        handler.add(implementation, navigationFragment)
        handler.add(implementation, navigationUI)
    }

    fun applyCore(handler: DependencyHandler) {
        handler.add(implementation, core)
        handler.add(implementation, appCompat)
        handler.add(implementation, material)
        handler.add(testImplementation, jUnit)
        handler.add(androidTestImplementation, extJunit)
        handler.add(androidTestImplementation, espresso)
    }


    fun applyArchComponents(handler: DependencyHandler) {
        handler.add(implementation, viewModel)
        handler.add(implementation, liveData)
        handler.add(implementation, lifecycleRuntime)
    }

    fun applyCoroutines(handler: DependencyHandler) {
        handler.add(implementation, coroutines)
    }

    fun applyRetrofit(handler: DependencyHandler) {
        handler.add(implementation, retrofit)
        handler.add(implementation, gson)
    }

    fun applyRoom(handler: DependencyHandler) {
        handler.add(implementation, room)
        handler.add(implementation, roomCompiler)
        handler.add(implementation, roomPaging)
    }


}