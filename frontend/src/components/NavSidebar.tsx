import { faBookBookmark, faBookmark, faFile, faGear, faHome, faImages, faMedal, faStore, faThumbsUp, faUser, faUserGroup, faUsers } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'

function NavSidebar() {
  return (
<div
  className="bg-primary opacity-95 w-1/4 p-5 rounded-lg h-full overflow-y-auto"
  style={{
    overflowX: 'auto',
    position: 'sticky',
    maxHeight: '90vh'
  }}
>
      <div className='profile border-b pb-5 border-gray-700'>
        <div className='relative flex'>
          <div className='pr-2'>
            <span className='notification-badge absolute top-[-4px] left-[-6px] w-4 h-4 bg-green-400 rounded-full flex items-center justify-center font-semibold'></span>
            <img src='https://pixner.net/circlehub/main/assets/images/avatar-1.png' alt='' />
          </div>
          <div className='flex flex-col justify-between'>
            <h3 className='font-bold text-white text-lg'>Bao Linh</h3>
            <p className='font-medium text-white text-sm'>@baolinhdev</p>
          </div>
        </div>
      </div>
      <div className='pt-5 mb-5 border-b border-gray-700'>
        <ul>
          <a href='#' className='flex items-center mb-6 text-white hover:text-blue-500 transition-colors duration-100'>
            <span className='w-10'>
              <FontAwesomeIcon icon={faHome} className='text-2xl mr-4' />
            </span>
            <span className='font-semibold'>
              <h4>Home</h4>
            </span>
          </a>
          <a href='#' className='flex items-center mb-6 text-white hover:text-blue-500 transition-colors duration-100'>
            <span className='w-10'>
              <FontAwesomeIcon icon={faUsers} className='text-2xl mr-4' />
            </span>
            <span className='font-semibold'>
              <h4>People</h4>
            </span>
          </a>
          <a href='#' className='flex items-center mb-6 text-white hover:text-blue-500 transition-colors duration-100'>
            <span className='w-10'>
              <FontAwesomeIcon icon={faMedal} className='text-2xl mr-4' />
            </span>
            <span className='font-semibold'>
              <h4>Event</h4>
            </span>
          </a>
          <a href='#' className='flex items-center mb-6 text-white hover:text-blue-500 transition-colors duration-100'>
            <span className='w-10'>
              <FontAwesomeIcon icon={faImages} className='text-2xl mr-4' />
            </span>
            <span className='font-semibold'>
              <h4>Pages</h4>
            </span>
          </a>
          <a href='#' className='flex items-center mb-6 text-white hover:text-blue-500 transition-colors duration-100'>
            <span className='w-10'>
              <FontAwesomeIcon icon={faUserGroup} className='text-2xl mr-4' />
            </span>
            <span className='font-semibold'>
              <h4>Group</h4>
            </span>
          </a>
          <a href='#' className='flex items-center mb-6 text-white hover:text-blue-500 transition-colors duration-100'>
            <span className='w-10'>
              <FontAwesomeIcon icon={faStore} className='text-2xl mr-4' />
            </span>
            <span className='font-semibold'>
              <h4>Marketplace</h4>
            </span>
          </a>
          <a href='#' className='flex items-center mb-6 text-white hover:text-blue-500 transition-colors duration-100'>
            <span className='w-10'>
              <FontAwesomeIcon icon={faBookmark} className='text-2xl mr-4' />
            </span>
            <span className='font-semibold'>
              <h4>Saved</h4>
            </span>
          </a>
          <a href='#' className='flex items-center mb-6 text-white hover:text-blue-500 transition-colors duration-100'>
            <span className='w-10'>
              <FontAwesomeIcon icon={faThumbsUp} className='text-2xl mr-4' />
            </span>
            <span className='font-semibold'>
              <h4>Favorites</h4>
            </span>
          </a>
          <a href='#' className='flex items-center mb-6 text-white hover:text-blue-500 transition-colors duration-100'>
            <span className='w-10'>
              <FontAwesomeIcon icon={faGear} className='text-2xl mr-4' />
            </span>
            <span className='font-semibold'>
              <h4>Settings</h4>
            </span>
          </a>
        </ul>
      </div> 
      <div>
        <h3 className='text-lg font-semibold text-white'>Your Shortcuts</h3> 
        <ul>
            <li className='flex items-center py-6'>
                <img className='mr-4' src="https://pixner.net/circlehub/main/assets/images/shortcuts-1.png" alt="shortcut" /> 
                <p className='font-semibold text-white'>Game Community</p>
            </li>
            <li className='flex items-center py-6'>
                <img className='mr-4' src="https://pixner.net/circlehub/main/assets/images/shortcuts-2.png" alt="shortcut" /> 
                <p className='font-semibold text-white'>Pixel Think (Member)</p>
            </li>
            <li className='flex items-center py-6'>
                <img className='mr-4' src="https://pixner.net/circlehub/main/assets/images/shortcuts-3.png" alt="shortcut" /> 
                <p className='font-semibold text-white'>8 Ball Pool</p>
            </li>
            <li className='flex items-center py-6'>
                <img className='mr-4' src="https://pixner.net/circlehub/main/assets/images/shortcuts-4.png" alt="shortcut" /> 
                <p className='font-semibold text-white'>Gembio</p>
            </li>
        </ul>
      </div>
    </div>
  )
}

export default NavSidebar
