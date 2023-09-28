import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faBell, faFileLines, faFilm, faHome, faMessage, faSearch, faUsers } from '@fortawesome/free-solid-svg-icons'
function Header() {
  return (
    <header className=' p-3 border border-solid bg-primary fixed top-0 right-0 left-0 z-30'>
      <div className='flex items-center justify-between'>
        <div className='flex items-center'>
          <a href=''>
            <img src='https://pixner.net/circlehub/main/assets/images/logo.png' alt='logo' />
          </a>
          {/* <div className='ml-4 relative bg-secondary rounded-lg flex items-center'>
            <div className='w-6'></div>
            <FontAwesomeIcon
              icon={faSearch}
              className='search-icon absolute top-1/2 left-3 transform -translate-y-1/2 text-white'
            />
            <input type='text' placeholder='Search Circlehubtio' className='bg-transparent p-4 pr-12 font-normal opacity-80 text-base' />
          </div> */}
        </div>
        <nav className='flex justify-center items-center'>
          <ul className='flex'>
            <li>
              <a href='#' className='text-white px-10'>
                <FontAwesomeIcon icon={faHome} className='text-2xl' />
              </a>
            </li>
            <li>
              <a href='#' className='text-white px-10'>
                <FontAwesomeIcon icon={faFileLines} className='text-2xl' />
              </a>
            </li>
            <li>
              <a href='#' className='text-white px-10'>
                <FontAwesomeIcon icon={faUsers} className='text-2xl' />
              </a>
            </li>
            <li>
              <a href='#' className='text-white px-10'>
                <FontAwesomeIcon icon={faFilm} className='text-2xl' />
              </a>
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
