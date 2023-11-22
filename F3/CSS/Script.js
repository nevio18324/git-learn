document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("agreeButton").addEventListener("click", (event) => {
        let i = 100;
        let myInterval = setInterval(function () {
            console.log("2")
            i = i - 1;
            document.getElementById("popup").style.opacity = i + "%";
            document.getElementById("header").style.opacity = -i + 100 + "%";
            if (i === 0){
                document.getElementById("popup").remove();
                clearInterval(myInterval);
            }
        }, 10)
    })
    //  let myTimeOut = setInterval(function () {
    //     console.log("Small")
    //
    //     if (document.getElementById("rightSide").getBoundingClientRect().width <= 825.6){
    //         document.getElementById("rightSide").style.visibility = "hidden";
    //         document.getElementById("listWithLinks").style.display = "flex";
    //         document.getElementById("rightSide").style.fontSize = "20px";
    //         const buttonToShowLinks = document.createElement("button");
    //         buttonToShowLinks.innerText = "☰";
    //         buttonToShowLinks.id = "buttonToShowLinks";
    //         buttonToShowLinks.style.background = "black"
    //         buttonToShowLinks.style.color = "white";
    //         buttonToShowLinks.style.visibility =
    //         document.getElementById("rightSide").add(buttonToShowLinks);
    //         clearInterval(myTimeOut);
    //         buttonToShowLinks.addEventListener("click", function () {
    //
    //         })
    //         document.body.appendChild(buttonToShowLinks);
    //     }else {
    //         document.getElementById("rightSide").style.visibility = "visible";
    //
    //     }
    // },10)
})



