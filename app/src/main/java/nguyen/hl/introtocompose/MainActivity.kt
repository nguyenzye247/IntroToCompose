package nguyen.hl.introtocompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nguyen.hl.introtocompose.ui.theme.IntroToComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroToComposeTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    var moneyCounter by remember { mutableStateOf(0) }
// A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color(0xFF546E7A)
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "$${moneyCounter}",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Spacer(modifier = Modifier.height(40.dp))
            CreateCircle(moneyCounter) { increment ->
                moneyCounter += increment
            }

            if(moneyCounter > 25) {
                Text(text = "Lots of money!")
            }
        }
    }
}

@Preview
@Composable
fun CreateCircle(moneyCounter: Int = 0, updateCounter: (Int) -> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .size(100.dp)
            .clickable {
                updateCounter.invoke(1)
            },
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(4.dp, 2.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Tap $moneyCounter", color = Color.Black, fontSize = 20.sp)
        }
    }
}

@Preview(name = "IntroToCompose", showBackground = true)
@Composable
fun GreetingPreview() {
    IntroToComposeTheme {
        MyApp()
    }
}