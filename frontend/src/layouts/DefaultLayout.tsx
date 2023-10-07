import { ReactNode } from 'react'
import Header from 'components/Header'
import Footer from 'components/Footer'
import NavSidebar from 'components/NavSidebar'
import WritePost from 'components/WritePost'
import Post from 'components/Post'
import ContactSidebar from 'components/ContactSidebar'

interface DefaultLayoutProps {
  children: ReactNode
}

function DefaultLayout({ children }: DefaultLayoutProps) {
  return (
    <>
      <Header />
      <div className='main bg-background p-3 h-screen flex'>
        <NavSidebar />
        <div className='w-1/4'></div>
        <main className='bg-gray-200 w-[47%] mt-20 mx-5'>
          <WritePost />
          <Post
            profileImage='https://pixner.net/circlehub/main/assets/images/avatar-1.png'
            name='Bao Linh'
            username='@baolinhdev'
            postContent='I created Roughly plugin to sketch crafted hand-drawn elements which can be used to any usage (diagrams/flows/decoration/etc).'
            postImage='https://pixner.net/circlehub/main/assets/images/post-img-1.png'
            commentCount={8}
            shareCount={20}
          />
          <Post
            profileImage='https://pixner.net/circlehub/main/assets/images/avatar-2.png'
            name='Viet Doan'
            username='@vietdoan'
            postContent='I created Roughly plugin to sketch crafted hand-drawn elements which can be used to any usage (diagrams/flows/decoration/etc).'
            postImage='https://pixner.net/circlehub/main/assets/images/post-img-1.png'
            commentCount={5}
            shareCount={3}
          />
        </main>
        <ContactSidebar />
      </div>
      {children}
      <Footer />
    </>
  )
}

export default DefaultLayout
