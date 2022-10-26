import Footer from "./components/Footer"
import Header from "./components/Header"
import About from "./pages/About"
import Games from "./pages/Games";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import TTAL from "./pages/TTAL";

export default function App() {
  return (
    <>
      <BrowserRouter>
        <Header />
        <Routes>
          <Route path='/'      element={<About />} />
          <Route path='/games' element={<Games />} />
          <Route path='/ttal' element={<TTAL />} />
        </Routes>
      </BrowserRouter>
      <Footer />
    </>
  )
}