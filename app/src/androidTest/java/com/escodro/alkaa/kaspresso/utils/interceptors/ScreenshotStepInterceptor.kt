package com.escodro.alkaa.kaspresso.utils.interceptors

import com.kaspersky.kaspresso.interceptors.watcher.testcase.StepWatcherInterceptor
import com.kaspersky.kaspresso.testcases.models.info.StepInfo
import io.qameta.allure.android.io.IMAGE_PNG
import io.qameta.allure.android.io.PNG_EXTENSION
import io.qameta.allure.espresso.AllureAndroidLifecycle
import com.escodro.alkaa.kaspresso.utils.EspressoScreenshot

/**
 * Интерсептор добавляет скриншот к упавшему шагу
 */
class ScreenshotStepInterceptor(
    private val screenShooter: EspressoScreenshot
) : StepWatcherInterceptor {

    override fun interceptAfterWithError(stepInfo: StepInfo, error: Throwable) {
        val tag = "${makeScreenshotTag(stepInfo)}_failure_${error.javaClass.simpleName}"
        screenShooter.takeScreenshot(tag).let {
            AllureAndroidLifecycle.addAttachment(
                name = tag,
                type = IMAGE_PNG,
                fileExtension = PNG_EXTENSION,
                file = it
            )
        }
    }

    private fun makeScreenshotTag(stepInfo: StepInfo): String = "${stepInfo.testClassName}_step_${stepInfo.ordinal}"
}
