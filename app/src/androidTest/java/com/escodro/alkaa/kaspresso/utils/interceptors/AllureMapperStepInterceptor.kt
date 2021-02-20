package com.escodro.alkaa.kaspresso.utils.interceptors

import com.kaspersky.kaspresso.interceptors.watcher.testcase.StepWatcherInterceptor
import com.kaspersky.kaspresso.testcases.models.info.StepInfo
import io.qameta.allure.android.Step

/**
 * Интерсептор для прокидывания step'ов Kaspresso в отчеты Allure
 */
class AllureMapperStepInterceptor : StepWatcherInterceptor {

    private var allureStep: Step? = null

    override fun interceptBefore(stepInfo: StepInfo) {
        allureStep = Step().apply { stepStart(stepInfo.description) }
    }

    override fun interceptAfterWithSuccess(stepInfo: StepInfo) {
        allureStep?.stepCompleted()
    }

    override fun interceptAfterWithError(stepInfo: StepInfo, error: Throwable) {
        allureStep?.stepThrown(error)
    }

    override fun interceptAfterFinally(stepInfo: StepInfo) {
        allureStep?.stepStop()
    }
}