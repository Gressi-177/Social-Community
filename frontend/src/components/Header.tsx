import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faBell, faFileLines, faFilm, faHome, faMessage, faUsers } from '@fortawesome/free-solid-svg-icons'
import { Link } from 'react-router-dom'
function Header() {
  return (
    <header className=' p-3 border border-solid bg-primary fixed top-0 right-0 left-0 z-30'>
      <div className='flex items-center justify-between'>
        <div className='flex items-center'>
          <Link to='/'>
            <img src='https://pixner.net/circlehub/main/assets/images/logo.png' alt='logo' />
          </Link>
        </div>
        <nav className='flex justify-center items-center'>
          <ul className='flex'>
            <li>
              <Link to='/' className='text-white px-10'>
                <FontAwesomeIcon icon={faHome} className='text-2xl' />
              </Link>
            </li>
            <li>
              <Link to='/' className='text-white px-10'>
                <FontAwesomeIcon icon={faFileLines} className='text-2xl' />
              </Link>
            </li>
            <li>
              <Link to='/' className='text-white px-10'>
                <FontAwesomeIcon icon={faUsers} className='text-2xl' />
              </Link>
            </li>
            <li>
              <Link to='/' className='text-white px-10'>
                <FontAwesomeIcon icon={faFilm} className='text-2xl' />
              </Link>
            </li>
          </ul>
        </nav>
        <div className='infor text-white flex items-center'>
          <span className='bg-secondary p-3 rounded-2xl mx-2 relative'>
            <span className='notification-badge absolute top-[-2px] left-[-8px] w-5 h-5 bg-red-600 rounded-full flex items-center justify-center font-semibold'>
              3
            </span>
            <FontAwesomeIcon icon={faMessage} className='text-2xl' />
          </span>
          <span className='bg-secondary p-3 rounded-lg mx-2 relative'>
            <span className='notification-badge absolute top-[-2px] left-[-8px] w-5 h-5 bg-red-600 rounded-full flex items-center justify-center font-semibold'>
              5
            </span>
            <FontAwesomeIcon icon={faBell} className='text-2xl' />
          </span>
          <div className='ml-2 relative'>
            <span className='notification-badge absolute top-[-4px] left-[-6px] w-4 h-4 bg-green-400 rounded-full flex items-center justify-center font-semibold'></span>
            <img src='https://pixner.net/circlehub/main/assets/images/avatar-1.png' alt='avatar' />
          </div>
        </div>
      </div>
    </header>
  )
}

export default Header
