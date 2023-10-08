# AuthenticationController

## Register

- **Endpoint**: `/api/v1/auth/register`
- **HTTP Method**: POST
- **Description**: Register a new user.
- **Request Body**:
    - `username` (String): The username of the new user.
    - `password` (String): The password of the new user.
- **Response**:
    - HTTP Status Code: 200 OK
    - JSON Response:
        - `status` (String): Success status.
        - `message` (String): Success message.
        - `data` (Object): The registered user information.

## Authenticate

- **Endpoint**: `/api/v1/auth/authenticate`
- **HTTP Method**: POST
- **Description**: Authenticate an existing user.
- **Request Body**:
    - `username` (String): The username of the user.
    - `password` (String): The password of the user.
- **Response**:
    - HTTP Status Code: 200 OK
    - JSON Response:
        - `status` (String): Success status.
        - `message` (String): Success message.
        - `data` (Object): The authentication response.

## Refresh Token

- **Endpoint**: `/api/v1/auth/refreshToken`
- **HTTP Method**: POST
- **Description**: Refresh the authentication token.
- **Request Body**:
    - `refresh_token` (String): The refresh token.
- **Response**:
    - HTTP Status Code: 200 OK
    - JSON Response:
        - `status` (String): Success status.
        - `message` (String): Success message.
        - `data` (Object): The refreshed authentication token.

# DocumentController

## Upload Files

- **Endpoint**: `/api/v1/upload`
- **HTTP Method**: POST
- **Description**: Upload one or more files.
- **Request**:
    - Form Data: `files` (Array of files): The files to upload.
- **Response**:
    - HTTP Status Code: 200 OK
    - JSON Response:
        - `status` (String): Success status.
        - `message` (String): Success message.
        - `data` (Array of Upload objects): Information about uploaded files.

## Get File

- **Endpoint**: `/api/v1/files/{filename:.+}`
- **HTTP Method**: GET
- **Description**: Retrieve a specific file by its filename.
- **Path Parameter**:
    - `filename` (String): The filename of the requested file.
- **Response**:
    - If the file exists:
        - HTTP Status Code: 200 OK
        - File content.
    - If the file does not exist:
        - HTTP Status Code: 404 Not Found

# PostController

## Add Post

- **Endpoint**: `/api/v1/post/add`
- **HTTP Method**: POST
- **Description**: Add a new post.
- **Request**:
    - `user` (User object): The authenticated user.
    - Request Body: `post` (Post object): The post to add.
- **Response**:
    - HTTP Status Code: 200 OK
    - JSON Response:
        - `status` (String): Success status.
        - `message` (String): Success message.
        - `data` (PostDto object): Information about the added post.

## List Posts

- **Endpoint**: `/api/v1/post/list`
- **HTTP Method**: GET
- **Description**: List posts with pagination.
- **Query Parameters**:
    - `pageNo` (Integer, default: 0): Page number.
    - `pageSize` (Integer, default: 10): Page size.
    - `sortBy` (String, default: "date01"): Sorting field.
- **Response**:
    - HTTP Status Code: 200 OK
    - JSON Response:
        - `status` (String): Success status.
        - `message` (String): Success message.
        - `data` (Object): Posts and pagination information.

## Get Post by ID

- **Endpoint**: `/api/v1/post/{postId}`
- **HTTP Method**: GET
- **Description**: Retrieve a specific post by its ID.
- **Path Parameter**:
    - `postId` (Long): The ID of the requested post.
- **Response**:
    - HTTP Status Code: 200 OK
    - JSON Response:
        - `status` (String): Success status.
        - `message` (String): Success message.
        - `data` (PostDto object): Information about the requested post.

# RelationshipController

## Get Friends

- **Endpoint**: `/api/v1/friends`
- **HTTP Method**: POST
- **Description**: Get a list of user's friends.
- **Request**:
    - `user` (User object): The authenticated user.
    - Request Body: `json` (Map<String, String>): Additional parameters.
- **Response**:
    - HTTP Status Code: 200 OK
    - JSON Response:
        - `status` (String): Success status.
        - `message` (String): Success message.
        - `data` (List of User objects): List of friends.
