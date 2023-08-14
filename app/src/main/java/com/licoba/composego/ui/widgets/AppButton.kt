package com.licoba.composego.ui.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.QuestionMark
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.licoba.composego.ui.theme.AppTheme
import com.licoba.composego.ui.theme.dimens

@Composable
fun AppButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    type: AppButtonType = AppButtonType.Filled,
    onClick: () -> Unit
) {
    when (type) {
        AppButtonType.Filled -> Button(
            onClick = onClick,
            modifier = modifier.fillMaxWidth(),
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                disabledContentColor = MaterialTheme.colorScheme.onSurface,
            ),
            shape = MaterialTheme.shapes.small

        ) {
            ButtonContent(text = text)
        }
        AppButtonType.Outlined -> OutlinedButton(
            onClick = onClick,
            modifier = modifier.fillMaxWidth(),
            enabled = enabled,
            shape = MaterialTheme.shapes.small,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.onBackground,
                contentColor = MaterialTheme.colorScheme.onSurface,
            ),

            ) {
            ButtonContent(text = text)
        }
        AppButtonType.Text -> {
            TextButton(
                onClick = onClick,
                modifier = modifier.fillMaxWidth(),
                enabled = enabled,
                shape = MaterialTheme.shapes.small
            ) {
                ButtonContent(text = text)
            }
        }
    }
}

@Composable
private fun ButtonContent(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleSmall,
        modifier = Modifier.padding(8.dp),
    )
}

@Preview
@Composable
fun PreviewOutlinedButton() {
    AppTheme {
        AppButton(text = "Outlined", type = AppButtonType.Outlined) {
        }
    }
}

@Preview
@Composable
fun PreviewTextButton() {
    AppTheme {
        AppButton(text = "Text Button", type = AppButtonType.Text) {
        }
    }
}

@Preview(name = "Primary Button")
@Composable
fun PreviewAppButton() {
    AppTheme {
        AppButton(text = "Text") {}
    }
}

@Preview(name = "Disabled Button")
@Composable
fun PreviewDisabledAppButton() {
    AppTheme {
        AppButton(text = "Text", enabled = false) {}
    }
}

enum class AppButtonType {
    Filled, Outlined, Text
}


@Composable
fun SmallClickableWithIconAndText(
    modifier: Modifier = Modifier,
    iconVector: ImageVector = Icons.Outlined.QuestionMark,
    iconContentDescription: String = "",
    text: String = "",
    onClick: () -> Unit
) {
    Row(
        modifier = modifier.clickable {
            onClick.invoke()
        },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = iconVector,
            contentDescription = iconContentDescription,
            tint = MaterialTheme.colorScheme.primary
        )
        Text(
            modifier = Modifier.padding(start = dimens.paddingSmall),
            text = text,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.primary
        )
    }
}