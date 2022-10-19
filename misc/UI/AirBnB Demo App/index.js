//sanity check
console.log("main js file loaded");

// user input to search web api

// temporary faking
const hotels = [
    {
        listingName: "Hampton Inn",
        price: "$50.00",
        roomType: "Private room",
        imgUrl: "https://media-cdn.tripadvisor.com/media/photo-s/26/74/64/5b/exterior.jpg"
    },
    {
        listingName: "Marriot",
        price: "$125.00",
        roomType: "Private room",
        imgUrl: "https://media-cdn.tripadvisor.com/media/photo-s/26/74/64/5b/exterior.jpg"
    },
    {
        listingName: "Lakinta",
        price: "$35.00",
        roomType: "Private room",
        imgUrl: "https://media-cdn.tripadvisor.com/media/photo-s/26/74/64/5b/exterior.jpg"
    },
    {
        listingName: "Doubletree",
        price: "$75.00",
        roomType: "Private room",
        imgUrl: "https://media-cdn.tripadvisor.com/media/photo-s/26/74/64/5b/exterior.jpg"
    },
]

// user returned info to dynamically reload the page

const populateData = (hotels) => {
    // we want to target the current hotel container
    const hotelContainer = document.getElementById('room-container');
    // empty it
    hotelContainer.innerHTML = "";
    // create a new element inside for each of our hotels
    for (room of hotels) {
        hotelContainer.innerHTML += `
        <div style="border: 1px solid black; margin: 20px" class="card p-3"> 
            <h3> ${room.listingName} </h3>
            <b> Price: ${room.price} </b>
            <p> Room type: ${room.roomType}</p>
            <img src="${room.imgUrl}">
        </div>`;
    }
}

// gather in user input

const printValues = () => {
    const destination = document.getElementById("destination").value;
    const checkIn     = document.getElementById("check-in").value;
    const checkOut    = document.getElementById("check-out").value;
    const guests      = document.getElementById("guests").value;
    console.log(destination,checkIn,checkOut,guests)
}

const doEverything = () => {
    printValues();
    populateData(hotels)
}

const searchButton = document.getElementById("search-button");
searchButton.onclick = doEverything;