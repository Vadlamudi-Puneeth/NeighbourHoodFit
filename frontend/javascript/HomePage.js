document.addEventListener("DOMContentLoaded", () => {
  const states = [
    "Delhi",
    "Bangalore",
    "Hyderabad",
    "tamilnadu",
    "Andhra Pradesh",
  ];

  const stateSelect = document.getElementById("state-select");
  const searchInput = document.getElementById("search-input");
  const searchButton = document.getElementById("search-button");
  const recentList = document.getElementById("recent-list");
  const noSearches = document.getElementById("no-searches");

  if (stateSelect) {
    states.forEach(state => {
      const option = document.createElement("option");
      option.value = state;
      option.textContent = state;
      stateSelect.appendChild(option);
    });
  }

  let recentSearches = JSON.parse(localStorage.getItem("recentSearches")) || [];
  renderRecentSearches();

  if (searchButton) {
    searchButton.addEventListener("click", async () => {
      const selectedState = stateSelect.value;
      const searchTerm = searchInput.value.trim();

      if (!searchTerm) {
        alert("Please enter a locality!");
        return;
      }

      const newSearch = {
        state: selectedState,
        term: searchTerm,
      };

      recentSearches = [newSearch, ...recentSearches].slice(0, 2);
      localStorage.setItem("recentSearches", JSON.stringify(recentSearches));
      renderRecentSearches();

      console.log("Searching:", selectedState, searchTerm);

      try {
        const response = await fetch(
          `http://localhost:8087/api/neighbors?state=${encodeURIComponent(selectedState)}&locality=${encodeURIComponent(searchTerm)}`
        );

        if (!response.ok) {
          throw new Error("Failed to fetch neighbors");
        }

        const data = await response.json();
        console.log("API result:", data);

const resultContainer = document.getElementById("search-results");
resultContainer.innerHTML = ""; // clear previous

if (data.length === 0) {
  resultContainer.textContent = "No neighbors found!";
} else {
  data.forEach(item => {
    const div = document.createElement("div");

    div.innerHTML = `
      <strong>ID:</strong> ${item.id} <br>
      <strong>Place:</strong> ${item.place} <br>
      <strong>Neighborhood:</strong> ${item.Neighborhood || item.neighborhood} <br>
      <strong>Average Rent:</strong> ₹${item.avg_rent} <br>
      <strong>Safety:</strong> ${item.safety} / 10 <br>
      <strong>Nightlife:</strong> ${item.nightlife} / 10 <br>
      <strong>Schools:</strong> ${item.schools} / 10 <br>
      <strong>Parks:</strong> ${item.parks} / 10 <br>
      <strong>Hospitals:</strong> ${item.hospitals} / 10 <br>
      <strong>Commute:</strong> ${item.commute} / 10
    `;

    div.style.padding = "8px";
    div.style.border = "1px solid #ccc";
    div.style.marginBottom = "5px";
    div.style.background = "#f9f9f9";

    resultContainer.appendChild(div);
  });
}
  

      } catch (error) {
        console.error(error);
        alert("Failed to fetch data from server.");
      }
    });
  }

  function renderRecentSearches() {
    if (!recentList || !noSearches) return;

    recentList.innerHTML = "";

    if (recentSearches.length === 0) {
      noSearches.style.display = "block";
    } else {
      noSearches.style.display = "none";
      recentSearches.forEach(item => {
        const li = document.createElement("li");
        li.textContent = `${item.state} | ${item.term}`;
        recentList.appendChild(li);
      });
    }
  }
});

// 📌 Register Form
const registerForm = document.getElementById("registerForm");

if (registerForm) {
  registerForm.addEventListener("submit", async (e) => {
    e.preventDefault();

    const user = {
      fullName: document.getElementById("fullName").value,
      mobileNo: document.getElementById("mobileNo").value,
      email: document.getElementById("email").value,
      password: document.getElementById("password").value,
      maritalStatus: document.getElementById("maritalStatus").value,
      noOfFamilyMembers: parseInt(document.getElementById("noOfFamilyMembers").value),
      profession: document.getElementById("profession").value,
      twoWheelerCount: parseInt(document.getElementById("twoWheelerCount").value) || 0,
      fourWheelerCount: parseInt(document.getElementById("fourWheelerCount").value) || 0,
    };

    try {
      const response = await fetch("http://localhost:8087/api/auth/register", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(user),
      });

      const result = await response.text();
      if (response.ok) {
        alert(result);
        window.location.href = "../html/Login.html";
      } else {
        alert("Registration failed: " + result);
      }
    } catch (err) {
      console.error(err);
      alert("Error submitting registration form.");
    }
  });
}

const loginForm = document.getElementById("loginForm");

if (loginForm) {
  loginForm.addEventListener("submit", async (e) => {
    e.preventDefault();

    const loginData = {
      email: document.getElementById("email").value,
      password: document.getElementById("password").value,
    };

    try {
      const response = await fetch("http://localhost:8087/api/auth/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(loginData),
      });

      const result = await response.text();

      if (response.ok) {
        alert(result);
        window.location.href = "../html/HomePage.html";
      } else {
        alert("Login failed: " + result);
      }
    } catch (err) {
      console.error(err);
      alert("Error submitting login form.");
    }
  });
}
