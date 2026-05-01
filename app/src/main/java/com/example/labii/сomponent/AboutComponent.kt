package com.example.labii.component

import com.arkivanov.decompose.ComponentContext

interface AboutComponent

class AboutComponentImpl(
    componentContext: ComponentContext
) : AboutComponent, ComponentContext by componentContext