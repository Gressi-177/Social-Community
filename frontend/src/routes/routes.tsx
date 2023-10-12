import { RouteProps } from 'react-router-dom'
import Home from '../pages/Home'
import About from '../pages/About'
import Login from '../pages/Login'
import Contact from '../pages/Contact'
import Register from '../pages/Register'

const routes: RouteProps[] = [
  { path: '/', element: <Home /> },
  { path: '/about', element: <About /> },
  { path: '/sign-in', element: <Login /> },
  { path: '/register', element: <Register /> },
  { path: '/contact', element: <Contact /> }
]

export default routes
