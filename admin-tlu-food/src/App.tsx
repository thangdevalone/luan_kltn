import { ThemeProvider, useTheme } from "@emotion/react"
import { useEffect } from "react"
import { Navigate, Route, Routes } from "react-router-dom"
import "./App.css"
import { LoadServer, NotFound } from "./components/Common"
import Admin from "./components/Layouts/Admin"
import { ProtectAdmin, ProtectAuth } from "./components/ProtectRouter"
import { LoginPage } from "./features/auth/pages/LoginPage"
import { RegisterPage } from "./features/auth/pages/RegisterPage"
function App() {
  const theme = useTheme()
  useEffect(() => {
    const VERSION = localStorage.getItem("APP_VERSION")
    console.log(import.meta.env.VITE_APP_VERSION)
    if (VERSION) {
      if (VERSION !== import.meta.env.VITE_APP_VERSION) {
        localStorage.clear()
        localStorage.setItem("APP_VERSION", import.meta.env.VITE_APP_VERSION)
      }
    } else {
      localStorage.setItem("APP_VERSION", import.meta.env.VITE_APP_VERSION)
    }
  }, [])
  return (
    <ThemeProvider theme={theme}>
      <Routes>
        <Route element={<LoadServer />}>
          <Route path="/" element={<Navigate to="/login" />} />
          <Route element={<ProtectAuth />}>
            <Route path="/login" element={<LoginPage />} />
            <Route path="/register" element={<RegisterPage />} />
          </Route>
          <Route element={<ProtectAdmin />}>
            <Route path="/admin/*" element={<Admin />} />
          </Route>
        </Route>
        <Route path="*" element={<NotFound />}></Route>
      </Routes>
    </ThemeProvider>
  )
}

export default App
