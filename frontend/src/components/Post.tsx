import { faComment, faEllipsis, faFile, faHeart, faPaperPlane, faShare } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { useDropzone } from 'react-dropzone'
interface PostProps {
  profileImage: string
  name: string
  username: string
  postContent: string
  postImage: string
  commentCount: number
  shareCount: number
}

function Post(props: PostProps) {
  const { getRootProps, getInputProps } = useDropzone()
  const { profileImage, name, username, postContent, postImage, commentCount, shareCount } = props

  return (
    <div className='p-4 bg-secondary rounded-xl mt-6'>
      <div className='profile flex justify-between items-center mb-4'>
        <div className='infor border-gray-700'>
          <div className='relative flex'>
            <div className='pr-2'>
              <span className='notification-badge absolute top-[-4px] left-[-6px] w-4 h-4 bg-green-400 rounded-full flex items-center justify-center font-semibold'></span>
              <img className='w-16 h-16 rounded-xl' src={profileImage} alt='' />
            </div>
            <div className='flex flex-col justify-between'>
              <h3 className='font-bold text-white text-lg'>{name}</h3>
              <p className='font-medium text-white text-sm'>{username}</p>
            </div>
          </div>
        </div>
        <div className='setting'>
          <FontAwesomeIcon icon={faEllipsis} className='text-white' />
        </div>
      </div>
      <div className='text'>
        <p className='text-white font-medium text-lg'>{postContent}</p>
      </div>
      <div className='image mt-3'>
        <img src={postImage} alt='post-img' className='rounded-xl' />
      </div>
      <div className='reaction flex justify-between items-center border-gray-700  border-b'>
        <div className='reaction-image py-4'>
          <ul className='flex items-center my-2'>
            <li className=' ml-[-8px]'>
              <img
                src='https://pixner.net/circlehub/main/assets/images/avatar-2.png'
                alt='reaction'
                className='rounded-full w-7 h-w-7'
              />
            </li>
            <li className='ml-[-8px]'>
              <img
                src='https://pixner.net/circlehub/main/assets/images/avatar-3.png'
                alt='reaction'
                className='rounded-full w-7 h-w-7'
              />
            </li>
            <li className='ml-[-8px]'>
              <img
                src='https://pixner.net/circlehub/main/assets/images/avatar-4.png'
                alt='reaction'
                className='rounded-full w-7 h-w-7'
              />
            </li>
            <li className='ml-[-8px]'>
              <div className='rounded-full w-7 h-7 flex items-center bg-secondary border'>
                <span className='text-textPlaceholder text-sm font-bold'>8+</span>
              </div>
            </li>
          </ul>
        </div>
        <div className='reaction-quantity'>
          <div className='react-list d-flex flex-wrap gap-6 align-items-center text-center my-2'>
            <button className='text-textPlaceholder mr-2'>{commentCount} Comments</button>
            <button className='text-textPlaceholder mr-2'>{shareCount} Shares</button>
          </div>
        </div>
      </div>
      <div className='reaction-btns py-4 border-gray-700  border-b'>
        <div className='flex justify-between items-center'>
          <button className=''>
            <FontAwesomeIcon icon={faHeart} className='mr-2 text-xl text-white' />
            <span className='text-base text-textPlaceholder font-semibold'>Like</span>
          </button>
          <button className=''>
            <FontAwesomeIcon icon={faComment} className='mr-2 text-xl text-white' />
            <span className='text-base text-textPlaceholder font-semibold'>Comment</span>
          </button>
          <button className=''>
            <FontAwesomeIcon icon={faShare} className='mr-2 text-xl text-white' />
            <span className='text-base text-textPlaceholder font-semibold'>Share</span>
          </button>
        </div>
      </div>
      <div className='write-comment mt-4'>
        <form action='#' className='flex justify-between items-center '>
          <div className='flex w-[85%]'>
            <div className='relative w-full flex items-center'>
              <input
                type='text'
                placeholder='Write a comment...'
                className='w-full bg-slate-800 p-3 opacity-80 rounded-xl'
              />
              <div
                {...getRootProps()}
                className='file-input absolute top-0 right-0 inline-block cursor-pointer flex items-center h-full mr-4'
              >
                <input {...getInputProps()} />
                <FontAwesomeIcon icon={faFile} className='file-icon w-6 h-6 text-white' />
              </div>
            </div>
          </div>
          <div className='btn-area d-flex w-[10%] mx-[8px]'>
            <button className='cmn-btn px-2 px-sm-5 px-lg-6 bg-primaryButton p-3 rounded-xl min-w-[60px]'>
              <FontAwesomeIcon icon={faPaperPlane} className='file-icon w-6 h-6 text-white' />
            </button>
          </div>
        </form>
      </div>
    </div>
  )
}

export default Post
