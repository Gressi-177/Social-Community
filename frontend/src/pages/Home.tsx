import Post from 'components/Post'
import WritePost from 'components/WritePost'
import DefaultLayout from 'layouts/DefaultLayout'

function Home() {
  return (
    <DefaultLayout>
      <main className=' w-[47%] mt-24 mx-5'>
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
    </DefaultLayout>
  )
}

export default Home
