import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faBell, faFileLines, faFilm, faGear, faHome, faMessage, faRightFromBracket, faUsers } from '@fortawesome/free-solid-svg-icons'
import { Link } from 'react-router-dom'
import { useState } from 'react'
function Header() {
  const [showDropdown, setShowDropdown] = useState(false)
  const handleDropdownToggle = () => {
    setShowDropdown(!showDropdown)
  }
  return (
    <header className=' p-3 border-none bg-primary fixed top-0 right-0 left-0 z-30'>
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
          <div className='ml-2 relative cursor-pointer' onClick={handleDropdownToggle}>
            <span className='notification-badge absolute top-[-4px] left-[-6px] w-4 h-4 bg-green-400 rounded-full flex items-center justify-center font-semibold'></span>
            <img src='https://pixner.net/circlehub/main/assets/images/avatar-1.png' alt='avatar' />
            {showDropdown && (
              <div className='dropdown absolute bg-secondary w-56 right-0 mt-4 rounded-xl p-4'>
                <div className='profile pb-5 '>
                  <div className='relative flex'>
                    <div className='pr-2'>
                      <span className='notification-badge absolute top-[-4px] left-[-6px] w-4 h-4 bg-green-400 rounded-full flex items-center justify-center font-semibold'></span>
                      <img src='https://pixner.net/circlehub/main/assets/images/avatar-1.png' alt='' />
                    </div>
                    <div className='flex flex-col justify-between'>
                      <h3 className='font-semibold text-white text-lg'>Bao Linh</h3>
                      <p className='font-medium text-white text-sm'>@baolinhdev</p>
                    </div>
                  </div>
                </div>
                <div className=' flex justify-center'>
                  <button className='text-center bg-primary w-full py-1 rounded-sm text-white hover:text-primaryButton font-semibold'>
                    View Profile
                  </button>
                </div>
                <div></div>
                <ul className='mt-3'>
                  <li className='flex items-center py-2 border-gray-700 hover:text-primaryButton border-b'>
                    <FontAwesomeIcon icon={faGear} className='mr-2 text-lg' />
                    <p>Setting</p>
                  </li>
                  <li className='flex items-center py-2 border-gray-700 hover:text-primaryButton border-b'>
                    <FontAwesomeIcon icon={faRightFromBracket} className='mr-2' />
                    <p className='font-semibold'>Sign out</p>
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
