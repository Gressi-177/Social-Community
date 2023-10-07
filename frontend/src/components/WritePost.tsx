import { faBroadcastTower, faCameraRetro, faFaceSmile } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'

function WritePost() {
  // bg-primary rounded-xl h-full overflow-y-auto overflow-x-auto fixed max-h-90vh top-24 left-2 scrollbar-thin scrollbar-thumb-gray-300 scrollbar-track-transparent
  return (
    <div className='mt-1 rounded-xl border bg-secondary p-4 border-none'>
      <div className='profile border-b border-gray-700'>
        <div className='relative flex'>
          <div className='pr-4'>
            <span className='notification-badge absolute top-[-4px] left-[-6px] w-4 h-4 bg-green-400 rounded-full flex items-center justify-center font-semibold'></span>
            <img src='https://pixner.net/circlehub/main/assets/images/avatar-1.png' alt='avatar' />
          </div>
          <form
            action='
            '
            className='w-full flex flex-col relative'
          >
            <textarea
              className='w-full p-4 rounded-md bg-slate-900 opacity-40 text-xs text-textPlaceholder'
              cols={10}
              rows={2}
              placeholder='Write something to Lerio..'
            ></textarea>
            <ul className='mt-4 flex justify-between'>
              <li className='flex items-center '>
                <FontAwesomeIcon icon={faBroadcastTower} className='mr-1 text-white' />
                <p className='text-textPlaceholder text-sm'>Live</p>
              </li>
              <li className='flex items-center '>
                <FontAwesomeIcon icon={faCameraRetro} className='mr-1 text-white' />
                <p className='text-textPlaceholder text-sm'>Photo/Video</p>
              </li>
              <li className='flex items-center '>
                <FontAwesomeIcon icon={faFaceSmile} className='mr-1 text-white' />
                <p className='text-textPlaceholder text-sm'>Fallings/Activity</p>
              </li>
            </ul>
          </form>
        </div>
      </div>
    </div>
  )
}

export default WritePost
