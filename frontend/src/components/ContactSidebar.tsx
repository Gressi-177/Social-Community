import {
  faBookmark,
  faEllipsis,
  faGear,
  faHome,
  faImages,
  faMedal,
  faStore,
  faThumbsUp,
  faUserGroup,
  faUsers
} from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'

function ContactSidebar() {
  return (
    <div className='bg-primary w-1/4 p-5 rounded-xl h-full overflow-y-auto overflow-x-auto fixed max-h-90vh top-24 right-2 scrollbar-thin scrollbar-thumb-gray-300 scrollbar-track-transparent'>
      <h3 className='text-white font-semibold text-lg mb-3'>Contact</h3>
      <ul>
        <li className='pb-5 flex justify-between items-center'>
          <div className=''>
            <div className='relative flex items-center'>
              <div className='pr-2'>
                <span className='notification-badge absolute top-[-4px] left-[-6px] w-4 h-4 bg-green-400 rounded-full flex items-center justify-center font-semibold'></span>
                <img src='https://pixner.net/circlehub/main/assets/images/avatar-1.png' alt='' />
              </div>
              <div className='flex flex-col justify-between'>
                <h3 className='font-semibold text-white text-lg'>Bao Linh</h3>
              </div>
            </div>
          </div>
          <div className='setting'>
            <FontAwesomeIcon icon={faEllipsis} className='text-white' />
          </div>
        </li>
        <li className='pb-5 flex justify-between items-center'>
          <div className=''>
            <div className='relative flex items-center'>
              <div className='pr-2'>
                <span className='notification-badge absolute top-[-4px] left-[-6px] w-4 h-4 bg-green-400 rounded-full flex items-center justify-center font-semibold'></span>
                <img src='https://pixner.net/circlehub/main/assets/images/avatar-2.png' alt='' />
              </div>
              <div className='flex flex-col justify-between'>
                <h3 className='font-semibold text-white text-lg'>Viet Doan</h3>
              </div>
            </div>
          </div>
          <div className='setting'>
            <FontAwesomeIcon icon={faEllipsis} className='text-white' />
          </div>
        </li>
        <li className='pb-5 flex justify-between items-center'>
          <div className=''>
            <div className='relative flex items-center'>
              <div className='pr-2'>
                <span className='notification-badge absolute top-[-4px] left-[-6px] w-4 h-4 bg-green-400 rounded-full flex items-center justify-center font-semibold'></span>
                <img src='https://pixner.net/circlehub/main/assets/images/avatar-3.png' alt='' />
              </div>
              <div className='flex flex-col justify-between'>
                <h3 className='font-semibold text-white text-lg'>Van Vien</h3>
              </div>
            </div>
          </div>
          <div className='setting'>
            <FontAwesomeIcon icon={faEllipsis} className='text-white' />
          </div>
        </li>
        <li className='pb-5 flex justify-between items-center'>
          <div className=''>
            <div className='relative flex items-center'>
              <div className='pr-2'>
                <span className='notification-badge absolute top-[-4px] left-[-6px] w-4 h-4 bg-green-400 rounded-full flex items-center justify-center font-semibold'></span>
                <img src='https://pixner.net/circlehub/main/assets/images/avatar-4.png' alt='' />
              </div>
              <div className='flex flex-col justify-between'>
                <h3 className='font-semibold text-white text-lg'>Manh Nhat</h3>
              </div>
            </div>
          </div>
          <div className='setting'>
            <FontAwesomeIcon icon={faEllipsis} className='text-white' />
          </div>
        </li>
        <li className='pb-5 flex justify-between items-center'>
          <div className=''>
            <div className='relative flex items-center'>
              <div className='pr-2'>
                <span className='notification-badge absolute top-[-4px] left-[-6px] w-4 h-4 bg-green-400 rounded-full flex items-center justify-center font-semibold'></span>
                <img src='https://pixner.net/circlehub/main/assets/images/avatar-5.png' alt='' />
              </div>
              <div className='flex flex-col justify-between'>
                <h3 className='font-semibold text-white text-lg'>Trong Dat</h3>
              </div>
            </div>
          </div>
          <div className='setting'>
            <FontAwesomeIcon icon={faEllipsis} className='text-white' />
          </div>
        </li>
      </ul>
    </div>
  )
}

export default ContactSidebar
