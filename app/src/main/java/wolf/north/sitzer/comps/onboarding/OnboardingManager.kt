package wolf.north.sitzer.comps.onboarding

import androidx.compose.runtime.Composable
import wolf.north.sitzer.mvvm.viewmodel.HomeScreenViewModel

@Composable
fun OnboardingManager(
    viewModel: HomeScreenViewModel,
    currentStep: Int
) {

    when (currentStep) {
        0 -> OnboardingIntroductionOverlay(onNext = { viewModel.nextOnboardingStep() })
        1 -> OurMissionCard(onNext = { viewModel.nextOnboardingStep() })
        2 -> HomeOnboardingInfo(onNext = { viewModel.nextOnboardingStep() })
        3 -> WorkoutOnboardingInfo(onNext = { viewModel.nextOnboardingStep() })
        4 -> ProfileOnboardingInfo(onNext = { viewModel.nextOnboardingStep() })
        5 -> FinalOnboardingInfo(onContinue = { viewModel.setOnboardingSeen() })
    }


}