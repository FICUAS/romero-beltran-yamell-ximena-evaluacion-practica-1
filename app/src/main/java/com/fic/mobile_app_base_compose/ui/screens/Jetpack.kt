import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ComicEventCard() 
{
    val paddingMed = dimensionResource(R.dimen.padding_medium)
    val spacerMed = dimensionResource(R.dimen.spacer_medium)

    Card(
        modifier = Modifier.fillMaxWidth().padding(paddingMed),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) 
    {
        Column 
        {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(R.dimen.height_header_image))
                    .background(Color.DarkGray)
            ) 
            {
                Surface(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(dimensionResource(R.dimen.padding_small)),
                    color = MaterialTheme.colorScheme.error,
                    shape = RoundedCornerShape(4.dp)
                ) 
                {
                    Text(
                        text = stringResource(R.string.label_badge_new),
                        modifier = Modifier.padding(dimensionResource(R.dimen.size_badge_padding)),
                        style = MaterialTheme.typography.labelSmall,
                        color = Color.White
                    )
                }
            }

            Column(modifier = Modifier.padding(paddingMed)) 
            {
                Text(
                    text = stringResource(R.string.label_comic_category),
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
                Text(
                    text = stringResource(R.string.label_comic_title),
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(R.string.label_comic_author),
                    style = MaterialTheme.typography.bodyMedium
                )
                
                Spacer(modifier = Modifier.height(spacerMed))

                EventDetailItem(
                    icon = Icons.Default.DateRange,
                    text = stringResource(R.string.label_comic_date)
                )
                EventDetailItem(
                    icon = Icons.Default.LocationOn,
                    text = stringResource(R.string.label_comic_location)
                )

                Spacer(modifier = Modifier.height(spacerMed))

                Text(
                    text = stringResource(R.string.label_comic_description),
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth().padding(paddingMed),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) 
            {
                TextButton(onClick = {}) 
                {
                    Icon(Icons.Default.Share, contentDescription = null)
                    Spacer(Modifier.width(4.dp))
                    Text(stringResource(R.string.btn_share))
                }
                Button(onClick = {}) 
                {
                    Icon(Icons.Default.ShoppingCart, contentDescription = null)
                    Spacer(Modifier.width(8.dp))
                    Text(stringResource(R.string.btn_add_cart))
                }
            }
        }
    }
}

@Composable
fun EventDetailItem(icon: ImageVector, text: String) 
{
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 2.dp)
    ) 
    {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(18.dp),
            tint = Color.Gray
        )
        Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_small)))
        Text(text = text, style = MaterialTheme.typography.bodyMedium)
    }
}