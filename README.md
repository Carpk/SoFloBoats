### SoFlo Performance Boats

Android app shows different model boats from NorTech.

#### How it works

App is set to query a /boats index page, uses Jsoup to parse the returning HTML for boat names and additional picture URLs. Once our Boat objects are created, we use FragmentStatePagerAdapter to manage boat Fragments.

#### Screenshots

![Image of one of the boats in landing view](https://raw.githubusercontent.com/Carpk/SoFloBoats/master/sampleImages/390NorTech.jpg)

![Image of a second boat in landing view](https://raw.githubusercontent.com/Carpk/SoFloBoats/master/sampleImages/392NorTech.jpg)
