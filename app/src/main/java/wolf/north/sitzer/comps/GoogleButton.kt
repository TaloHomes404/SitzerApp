package wolf.north.sitzer.comps

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import wolf.north.sitzer.R

@Composable
fun GoogleButton(
    icon: Painter = painterResource(id = R.drawable.google_icon),
    shape: RoundedCornerShape = RoundedCornerShape(4.dp),
    border: BorderStroke = BorderStroke(1.dp, Color.LightGray),
    bgColor : Color = Color.White,
    progressIndicatorColor: Color = colorResource(id = R.color.welcome_screen_bg)
) {
    var clicked by remember {
        mutableStateOf(false)
    }

    Surface(
        onClick = {clicked = !clicked},
        shape = shape,
        border = border,
        color = bgColor
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 12.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)
                .animateContentSize(
                    animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing)
                )){
            Icon(
                painter = icon,
                contentDescription = "google icon",
                tint = Color.Unspecified)

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = if(clicked) "Creating account..." else "Sign up with Google",
                fontSize = 20.sp, fontWeight = FontWeight.Bold)

            if(clicked){
                Spacer(modifier = Modifier.width(8.dp))
                CircularProgressIndicator(
                    trackColor = progressIndicatorColor,
                    strokeWidth = 2.dp,
                    modifier = Modifier
                        .height(28.dp)
                        .width(28.dp))
            }
        }
    }
}

@Preview
@Composable
fun GoogleButtonPreview() {
    GoogleButton()
}
