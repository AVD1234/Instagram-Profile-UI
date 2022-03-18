package com.ashishtech.instagramprofileui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalFoundationApi::class)

@Composable
fun ProfileScreen() {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(name = "dawkharashish", modifier = Modifier.padding(10.dp))
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(25.dp))
        ButtonSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(25.dp))
        HighlightSection(
            highlights = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.tony_stark_new),
                    text = "BookIcon"
                ),
                ImageWithText
                    (
                    image = painterResource(id = R.drawable.tony_stark_new),
                    text = "Cover"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.tony_stark_new),
                    text = "Facebook"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.tony_stark_new),
                    text = "Rating"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.tony_stark_new),
                    text = "Tony"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.tony_stark_new),
                    text = "Instagram"
                )
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        PostTabview(
            imageWithText = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_baseline_grid_on_24),
                    text = "Posts"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_baseline_video_library_24),
                    text = "Reels"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_baseline_live_tv_24),
                    text = "IGTV"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_baseline_perm_contact_calendar_24),
                    text = "Profile"
                ),
            )
        ) {
            selectedTabIndex = it
        }
        when (selectedTabIndex) {
            0 -> PostSection(
                posts = listOf(
                    painterResource(id = R.drawable.tony_stark_new),
                    painterResource(id = R.drawable.tony_stark_new),
                    painterResource(id = R.drawable.tony_stark_new),
                    painterResource(id = R.drawable.tony_stark_new),
                    painterResource(id = R.drawable.tony_stark_new),
                    painterResource(id = R.drawable.tony_stark_new),
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

}

@Composable
fun TopBar(
    name: String, modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Icon(
            painterResource(id = R.drawable.ic_baseline_notifications_24),
            contentDescription = "back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Icon(
            painterResource(id = R.drawable.ic_baseline_more_vert_24),
            contentDescription = "back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            RoundImage(
                image = painterResource(id = R.drawable.instagram),
                modifier = Modifier
                    .size(90.dp)
                    .weight(3f)
                    .padding(4.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            StatsSection(modifier = Modifier.weight(7f))

        }
        Spacer(modifier = Modifier.height(8.dp))
        ProfileDescription(
            displayName = "Ashish Dawkhar",
            description = "#_Indian Entrepreneur\n" +
                    "Co-Founder & CEO BOOKQUEEN",
            url = "Com.bookqueen,bookqueen",
            followedBy = listOf("Ajay", "Sagar")
        )
    }
}

@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )

}

@Composable
fun StatsSection(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        Profilestat(numberText = "200", text = "Posts")
        Profilestat(numberText = "10K", text = "Followers")
        Profilestat(numberText = "150", text = "Following")
    }
}

@Composable
fun Profilestat(
    numberText: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = text,
            fontSize = 14.sp
        )
    }
}

@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = url,
            color = Color(0xFF3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        if (followedBy.isNotEmpty()) {
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    append("Followed by ")
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size - 1) {
                            append(", ")
                        }
                    }
                    if (followedBy.size >= 2) {
                        append(" and ")
                        pushStyle(boldStyle)
                        append("${followedBy.size - 2} others")
                    }
                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }
    }
}

@Composable
fun ButtonSection(
    modifier: Modifier = Modifier
) {
    val minWidth = 95.dp
    val height = 30.dp
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Email",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .size(height)
        )
    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon: ImageVector? = null
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ) {
        if (text != null) {
            Text(
                text = text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }
}

@Composable
fun HighlightSection(
    modifier: Modifier = Modifier,
    highlights: List<ImageWithText>
) {
    LazyRow(modifier = modifier) {
        items(highlights.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(end = 15.dp)
            ) {
                RoundImage(
                    image = highlights[it].image,
                    modifier = Modifier.size(70.dp)
                )
                Text(
                    text = highlights[it].text,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
fun PostTabview(
    modifier: Modifier = Modifier,
    imageWithText: List<ImageWithText>,
    OnTabselected: (selectedIndex: Int) -> Unit
) {
    var selectedTab by remember {
        mutableStateOf(0)
    }
    val inactiveTab = Color.Gray
    TabRow(
        selectedTabIndex = selectedTab,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier,
    ) {
        imageWithText.forEachIndexed { index, item ->
            Tab(selected = selectedTab == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveTab, onClick = {
                    selectedTab = index
                    OnTabselected(index)
                }) {
                Icon(
                    painter = item.image,
                    contentDescription = item.text,
                    tint = if (selectedTab == index) Color.Black else inactiveTab,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }

    }
}

@ExperimentalFoundationApi
@Composable
fun PostSection(
    posts: List<Painter>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = modifier
            .scale(1.01f)
    ) {
        items(posts.size) {
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )
            )
        }
    }
}