import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import {
  faBell,
  faFileLines,
  faFilm,
  faGear,
  faHome,
  faMessage,
  faRightFromBracket,
  faRightToBracket,
  faUserPlus,
  faUsers
} from '@fortawesome/free-solid-svg-icons'
import { Link } from 'react-router-dom'
import { useState } from 'react'
function Header() {
  const [showDropdown, setShowDropdown] = useState(false)

  const toggleDropdown = () => {
    setShowDropdown(!showDropdown)
  }

  return (
    <header className=' p-3 border-non bg-primary fixed top-0 right-0 left-0 z-30'>
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
          <div className='ml-2 relative cursor-pointer' onClick={toggleDropdown}>
            <span className='notification-badge absolute top-[-4px] left-[-6px] w-4 h-4 bg-green-400 rounded-full flex items-center justify-center font-semibold'></span>
            <img src='https://pixner.net/circlehub/main/assets/images/avatar-1.png' alt='avatar' />
            {showDropdown && (
              <div className='absolute bg-secondary right-0 w-56 mt-2 p-5 rounded-lg'>
                <div className='profile mb-3 '>
                  <div className='relative flex items-center'>
                    <div className='pr-2'>
                      <span className='notification-badge absolute top-[-4px] left-[-6px] w-4 h-4 bg-green-400 rounded-full flex items-center justify-center font-semibold'></span>
                      <img
                        src='https://pixner.net/circlehub/main/assets/images/avatar-1.png'
                        alt=''
                        className='w-10 h-10'
                      />
                    </div>
                    <div className='flex flex-col justify-between'>
                      <h3 className='font-semibold text-white text-lg'>Baolinh</h3>
                      <p className='font-medium text-white text-sm'>@Baolinh</p>
                    </div>
                  </div>
                </div>
                <Link
                  to='/'
                  className='flex items-center text-white hover:text-blue-500 transition-colors duration-100'
                >
                  <div className='w-full bg-primary flex items-center justify-center py-2 rounded-md group mb-3'>
                    <p className='transition-colors duration-300 group-hover:text-blue-500 font-semibold'>
                      View profile
                    </p>
                  </div>
                </Link>
                <ul>
                  <li className='py-2 border-gray-700  border-b'>
                    <Link to='profile-edit.html' className='flex items-center group'>
                      <FontAwesomeIcon
                        icon={faGear}
                        className='mr-2 text-xl transition-colors duration-300 group-hover:text-blue-500'
                      />
                      <p className='text-lg font-medium transition-colors duration-300 group-hover:text-blue-500'>
                        Settings & Privacy
                      </p>
                    </Link>
                  </li>
                  <li className='py-2 border-gray-700  border-b'>
                    <Link to='/sign-in' className='flex items-center group'>
                      <FontAwesomeIcon
                        icon={faRightToBracket}
                        className='mr-2 text-xl transition-colors duration-300 group-hover:text-blue-500'
                      />
                      <p className='text-lg font-medium transition-colors duration-300 group-hover:text-blue-500'>
                        Sign in
                      </p>
                    </Link>
                  </li>
                  <li className='py-2 border-gray-700  border-b'>
                    <Link to='/register' className='flex items-center group'>
                      <FontAwesomeIcon
                        icon={faUserPlus}
                        className='mr-2 text-xl transition-colors duration-300 group-hover:text-blue-500'
                      />
                      <p className='text-lg font-medium transition-colors duration-300 group-hover:text-blue-500'>
                        Register
                      </p>
                    </Link>
                  </li>
                  <li className='py-2'>
                    <Link to='/sign-out' className='flex items-center group'>
                      <FontAwesomeIcon
                        icon={faRightFromBracket}
                        className='mr-2 text-xl transition-colors duration-300 group-hover:text-blue-500'
                      />
                      <p className='text-lg font-medium transition-colors duration-300 group-hover:text-blue-500'>
                        Sign out
                      </p>
                    </Link>
                  </li>
                </ul>
              </div>
            )}
          </div>
        </div>
      </div>
    </header>
  )
}

export default Header
