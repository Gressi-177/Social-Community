import React, { useState, useEffect } from 'react'
import axios from 'axios'
import Post from 'components/Post'
import WritePost from 'components/WritePost'
import DefaultLayout from 'layouts/DefaultLayout'

interface PostData {
  id: number
  user: {
    id: number
    status: number
    role: string
    username: string
    imgUrl: string
    created_at: string
    updated_at: string
  }
  imgUrl: string
  status01: number
  content01: string
  createdAt: string
  updatedAt: string
}

function Home() {
  const baseURL = process.env.REACT_APP_BASE_URL // Replace with your base URL

  const [posts, setPosts] = useState<PostData[] | null>(null)
  console.log(baseURL)

  useEffect(() => {
    const axiosInstance = axios.create({
      baseURL,
      headers: {
        'Content-Type': 'application/json'
      }
    })

    console.log(baseURL)

    const fetchPost = async () => {
      try {
        const response = await axiosInstance.get<any>('/api/v1/post/list?page=0&limit=10&sortBy=date01')
        const data = response.data.data.posts
        console.log('data', data)

        setPosts(data)
      } catch (err) {
        console.error(err)
      }
    }

    fetchPost()
  }, [[accessControlOrigin, baseURL]])

  return (
    <DefaultLayout>
      <main className='w-[47%] mt-24 mx-5'>
        <WritePost />
        {posts &&
          posts.map((item) => (
            <Post
              key={item.id}
              profileImage={`${baseURL}/api/v1/files/${item.user.imgUrl}`}
              name={item.user?.username}
              username={`@${item.user?.username}`}
              postContent={item.content01}
              postImage={`${baseURL}/api/v1/files/${item.imgUrl}`}
              commentCount={0}
              shareCount={0}
            />
          ))}
      </main>
    </DefaultLayout>
  )
}

export default Home
