const userTab = document.querySelector("[data-userWeather]");
const searchTab = document.querySelector("[data-searchWeather]");
const userContainer = document.querySelector(".weather-container");

const grantAccessContainer = document.querySelector(".grant-location-container");
const searchForm = document.querySelector("[data-searchForm]");
const loadingScreen = document.querySelector(".loading-container");
const userInfoContainer = document.querySelector(".user-info-container");



let currentTab = userTab;
const API_KEY = "d1845658f92b31c64bd94f06f7188c9c";
//adding classList properties to oldTab(currentTab)
currentTab.classList.add("current-tab");
getfromSessionStorage();


function switchTab(newTab) 
{ 
    // if condition checks if we are clicking the same button or not it dosent change in function but 
    //brings optimization
     if(currentTab!=newTab)
    {
        //if current tab is user then remove its styling and give it to the one which is clicked
        currentTab.classList.remove("current-tab");
        currentTab = newTab;
        currentTab.classList.add("current-tab");

        //.contains method is a boolean
       
        
        if(searchForm.classList.toggle("active")) 
        {

            //Starting mein search form invisible hai(active = 0) so we are
            // adding active to it

            //(SEARCH TAB)
            userInfoContainer.classList.remove("active");
            grantAccessContainer.classList.remove("active");
            searchForm.classList.add("active");
        } 
    
        
        //nahi to abhi mein search waale tab mein hu ab switch karna to 
        //weather tab
        else
        { 
            //(YOUR WEATHER TAB)
            searchForm.classList.remove("active");
            userInfoContainer.classList.remove("active");

            //ABHI YOUR WEATHER TAB PE HAIN
            getfromSessionStorage();
        }


    }
}



userTab.addEventListener("click", () => {
    //pass clicked tab as input paramter
    switchTab(userTab);
});


searchTab.addEventListener("click", () => {
    //pass clicked tab as input paramter
    switchTab(searchTab);
});


//CHECK if coordinates are alrady present in storage



//check if coordinates are already present in session storage
function getfromSessionStorage() 
{
    const localCoordinates = sessionStorage.getItem("user-coordinates");
    if(!localCoordinates) 
    {
            //agar TUMAHRA coordinated nahi hai to grantacces(geolocation) dikhao
            grantAccessContainer.classList.add("active");
    }
        else
         {
            const coordinates = JSON.parse(localCoordinates);
            fetchUserWeatherInfo(coordinates);
         }
    
}



//HAME LOADING TAB DIKHAANA HAI JAB  coordinates mil gaye hai
async function fetchUserWeatherInfo(coordinates) 
{
    const {lat, lon} = coordinates;
    // make grantcontainer invisible
    grantAccessContainer.classList.remove("active");
    //make loader visible
    loadingScreen.classList.add("active");

    //API CALL
    try 
    {
        const response = await fetch(
            `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${API_KEY}&units=metric`
          );
        const  data = await response.json();

        loadingScreen.classList.remove("active");
        userInfoContainer.classList.add("active");

        //Neeche waale ka function ka kaam hai ki jo
        // data(flag,place,temp) UI PE DIKHAANA 
        renderWeatherInfo(data);
    }

    catch(err) 
    {
        loadingScreen.classList.remove("active");
        //HW

    }

}



//weatherInfo  fetchUserInfo mein hai i.e data to pass kiya 
function renderWeatherInfo(weatherInfo) 
{

    //UI pe DIKHAANE KE LIYE We have to firstly fetch elements
    const cityName = document.querySelector("[data-cityName]");
    const countryIcon = document.querySelector("[data-countryIcon]");
    const desc = document.querySelector("[data-weatherDesc]");
    const weatherIcon = document.querySelector("[data-weatherIcon]");
    const temp = document.querySelector("[data-temp]");
    const windspeed = document.querySelector("[data-windspeed]");
    const humidity = document.querySelector("[data-humidity]");
    const cloudiness = document.querySelector("[data-cloudiness]");

    console.log(weatherInfo);

    //fetch values from weatherINfo object and put it UI elements
    cityName.innerText = weatherInfo?.name;
    countryIcon.src = `https://flagcdn.com/144x108/${weatherInfo?.sys?.country.toLowerCase()}.png`;
    desc.innerText = weatherInfo?.weather?.[0]?.description;
    weatherIcon.src = `http://openweathermap.org/img/w/${weatherInfo?.weather?.[0]?.icon}.png`;
    temp.innerText = `${weatherInfo?.main?.temp} °C`;
    windspeed.innerText = `${weatherInfo?.wind?.speed} m/s`;
    humidity.innerText = `${weatherInfo?.main?.humidity}%`;
    cloudiness.innerText = `${weatherInfo?.clouds?.all}%`;


}



function getLocation() 
{
    if(navigator.geolocation)
     {
        navigator.geolocation.getCurrentPosition(showPosition);
    }
    else 
    {
        x.innerHTML = "Geolocation is not supported by this browser.";
    }
    
}





function showPosition(position) 
{
//object of user coordinate
    const userCoordinates =
     {
        lat: position.coords.latitude,
        lon: position.coords.longitude,
    }

    sessionStorage.setItem("user-coordinates", JSON.stringify(userCoordinates));
    fetchUserWeatherInfo(userCoordinates);

}



const grantAccessButton = document.querySelector("[data-grantAccess]");
grantAccessButton.addEventListener("click", getLocation);
const searchInput = document.querySelector("[data-searchInput]");

//SUBMIT event listener fires only on FORM not on button or input
searchForm.addEventListener("submit", (e) => 
{
    e.preventDefault();
    let cityName = searchInput.value;

    if(cityName === "")
        return;
    else 
        fetchSearchWeatherInfo(cityName);
})



async function fetchSearchWeatherInfo(city) 
{
    loadingScreen.classList.add("active");
    userInfoContainer.classList.remove("active");
    grantAccessContainer.classList.remove("active");

    try 
    {
        const response = await fetch(
            `https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${API_KEY}&units=metric`
          );
        const data = await response.json();
        loadingScreen.classList.remove("active");
        userInfoContainer.classList.add("active");
        renderWeatherInfo(data);
    }
    catch(err) 
    {
        //hW
    }
}

























































































// async function fetchWeatherDetails()
// { 
// try
// {
//      const city = "London"; // Replace "London" with the desired city name   
//     const url = `https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${API_KEY}&units=metric`;   
//     const response = await fetch(url);    
//     const data = await response.json();
//    console.log('weather',data);
// }

// catch(err)
// { 
//     console.log('error!!data not fetched')
// }

// }



// async function getCustomWeather()
// { 
//     try
//     {
//     let lat = 7.11;
//     let lon = 33.22; 
//     const url = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${API_KEY}&units=metric`;
//     let response = await fetch(url);
//     let data = await response.json();

//     console.log(data);
//     }

//     catch(err)
//     { 
//         console.log("data not available");
//     }

// }


// var x = document.getElementById("demo");
// function getLocation() {
//   if (navigator.geolocation) {
//     navigator.geolocation.getCurrentPosition(showPosition);
//   } else {
//     x.innerHTML = "Geolocation is not supported by this browser.";
//   }
// }

// function showPosition(position) {
//   x.innerHTML = "Latitude: " + position.coords.latitude +
//   "<br>Longitude: " + position.coords.longitude;
//                                 }









// FROM LINE 170 TO 196 W3school se CHAAPA HAI (https://www.w3schools.com/html/html5_geolocation.asp)
// JYAADA TENSION NAHI LENA AUR JAB W3SCHOOL MEIN RUN KAREGA TO console.log(x) to see latitude and long on cosole






 // The next line, sessionStorage.setItem("user-coordinates", JSON.stringify(userCoordinates));, saves the user's coordinates in the browser's sessionStorage.
//  This means that the coordinates will be available even if the user refreshes the page.