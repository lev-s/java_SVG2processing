#java_SVG2processing

**It is a Java Maven project to parse SVG file and draw it on processing.
**

<!-- I tried to use Java Batik Toolkit for parsing SVG, but no luck. It took long time to explore it and use it in easier way. I prefered to use XML parse library from Java as my SVG is super simple well organized XML file.  -->


Below is sample SVG file that I have parsed:

<svg height="400" width="450">
 <path d="M 10 10 L 10 10" stroke="red"
       stroke-width="3" fill="none"/>
  <path id="lineAB" d="M 100 350 L 250 50" stroke="red"
  stroke-width="3" fill="none" />
  <path id="lineBC" d="M 250 50 L 400 350" stroke="red"
  stroke-width="3" fill="none" />
  <path d="M 175 200 L 325 200" stroke="green" stroke-width="3"
  fill="none" />
  <path d="M 100 350 Q 250 200 400 350" stroke="blue"
  stroke-width="5" fill="none" />
  <!-- Mark relevant points -->
    <circle id="pointA" cx="100" cy="350" r="3" stroke="yellow" fill="none"/>
    <circle id="pointB" cx="250" cy="50" r="3" stroke="yellow" fill="none"/>
    <circle id="pointC" cx="400" cy="350" r="3" stroke="yellow" fill="none"/>
  <!-- Label the points -->

    <text x="100" y="350" dx="-30">A</text>
    <text x="250" y="50" dy="-10">B</text>
    <text x="400" y="350" dx="30">C</text>
</svg>


![test](https://user-images.githubusercontent.com/34050903/162162832-f792d9fc-dddd-437e-92b8-0a7b032a2685.svg)



And here is the result the app showing:

![image](https://user-images.githubusercontent.com/34050903/162161936-1a220e9a-789c-4d8f-9805-b04cd5d29ec4.png)

