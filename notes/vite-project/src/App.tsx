import Footer from "./components/Footer"
import Header from "./components/Header"
import About from "./pages/About"
import Games from "./pages/Games";
import { BrowserRouter, Route, Routes } from "react-router-dom";

export default function App() {
  return (
    <>
      <BrowserRouter>
        <Header />
        <Routes>
          <Route path='/'      element={<About />} />
          <Route path='/games' element={<Games />} />
        </Routes>
      </BrowserRouter>
      <Footer />
    </>
  )
}