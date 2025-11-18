// Reemplaza este ID por tu propio CLIENT_ID de Google
const GOOGLE_CLIENT_ID = "TU_CLIENT_ID_AQUI";

document.getElementById("token-google").onclick = () => {
  google.accounts.id.initialize({
    client_id: GOOGLE_CLIENT_ID,
    callback: handleGoogleResponse
  });

  google.accounts.id.prompt(); // Abre el cuadro de Google
};

function handleGoogleResponse(response) {
  const id_token = response.credential; // AQUÍ TE DA EL TOKEN DE GOOGLE

  console.log("Token recibido:", id_token);

  // Enviar token a tu backend para autenticarlo
  fetch("https://tu-servidor.com/api/google-login", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ token: id_token })
  })
  .then(r => r.json())
  .then(data => {
    console.log("Respuesta del backend:", data);
  })
  .catch(err => console.error("Error:", err));
}
