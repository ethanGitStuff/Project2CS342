# JavaFX Weather App for Software Design
*Starter code provided by CS342 UIC in Spring of 2026*
*Project finished by Ethan and Hasfah*

This app was created for the purpose of providing the Weather forecast using the National Weather Service API.
While using JavaFX, we also used fxml and Scenebuilder to help design the different scenes, along with the website Figma
to help create an initial design. We decided to make the app in the style of a mobile weather app, since that is most likely 
where a user would use such software.

By default, the program sets the user's location to Chicago, and using the NWS API it displays the currect forecast
and the forecast for the next 3 days. We added the ability for the user to search from the top 1000 cities by
population to show forecast of, or the user may enter their own latitude and longitude to receive the forecast for
that location (assuming it is inside the U.S.). These cities are added to the favorites list, but can also be removed
by the user if they no longer need that location favorited.

We created a custom JavaFX component to comprise the bottom menu, since it was going to be displayed on every scene we figured
creating a new object that behaved the same would be beneficial, but getting it to work in scenebuilder was quite the headache. 

*Link to demo: https://youtu.be/fRy3GJdQnSo*
