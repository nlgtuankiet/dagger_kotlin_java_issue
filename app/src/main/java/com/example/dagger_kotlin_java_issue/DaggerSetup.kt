package com.example.dagger_kotlin_java_issue

import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.multibindings.IntoSet
import javax.inject.Inject

class Bar @Inject constructor()

class Foo @AssistedInject constructor(
    @Assisted bar: Bar,
    bar2: Bar
) {
    @AssistedInject.Factory
    interface Factory {
        fun create(bar: Bar): Foo
    }
}

@Module
interface Binding {
    @Binds
    @IntoSet
    fun bind(factory: Foo_AssistedFactory): Foo.Factory
}

@Component(modules = [Binding::class])
interface Component