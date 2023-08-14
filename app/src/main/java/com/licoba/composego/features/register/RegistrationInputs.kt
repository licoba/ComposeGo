package com.licoba.composego.features.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import com.licoba.composego.R
import com.licoba.composego.ui.theme.dimens
import com.licoba.composego.ui.widgets.AppButton
import com.licoba.composego.ui.widgets.EmailTextField
import com.licoba.composego.ui.widgets.MobileNumberTextField
import com.licoba.composego.ui.widgets.PasswordTextField

@Composable
fun RegistrationInputs(
    registrationState: RegistrationState,
    onEmailIdChange: (String) -> Unit,
    onMobileNumberChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
    onSubmit: () -> Unit,
) {
    // Login Inputs Section
    Column(modifier = Modifier.fillMaxWidth()) {

        // Email ID
        EmailTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimens.paddingLarge),
            value = registrationState.emailId,
            onValueChange = onEmailIdChange,
            label = stringResource(id = R.string.registration_email_label),
            isError = registrationState.errorState.emailIdErrorState.hasError,
            errorText = stringResource(id = registrationState.errorState.emailIdErrorState.errorMessageStringResource),
            imeAction = ImeAction.Next
        )

        // Mobile Number
        MobileNumberTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimens.paddingLarge),
            value = registrationState.mobileNumber,
            onValueChange = onMobileNumberChange,
            label = stringResource(id = R.string.registration_mobile_label),
            isError = registrationState.errorState.mobileNumberErrorState.hasError,
            errorText = stringResource(id = registrationState.errorState.mobileNumberErrorState.errorMessageStringResource),
            imeAction = ImeAction.Next
        )


        // Password
        PasswordTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimens.paddingLarge),
            value = registrationState.password,
            onValueChange = onPasswordChange,
            label = stringResource(id = R.string.registration_password_label),
            isError = registrationState.errorState.passwordErrorState.hasError,
            errorText = stringResource(id = registrationState.errorState.passwordErrorState.errorMessageStringResource),
            imeAction = ImeAction.Next
        )

        // Confirm Password
        PasswordTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimens.paddingLarge),
            value = registrationState.confirmPassword,
            onValueChange = onConfirmPasswordChange,
            label = stringResource(id = R.string.registration_confirm_password_label),
            isError = registrationState.errorState.confirmPasswordErrorState.hasError,
            errorText = stringResource(id = registrationState.errorState.confirmPasswordErrorState.errorMessageStringResource),
            imeAction = ImeAction.Done
        )

        // Registration Submit Button
        AppButton(
            modifier = Modifier.padding(top = dimens.paddingExtraLarge),
            text = stringResource(id = R.string.registration_button_text),
            onClick = onSubmit
        )


    }
}