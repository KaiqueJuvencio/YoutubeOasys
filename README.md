#  :film_projector: YoutubeOasys :clapper:

YoutubeOasys is an application that will pull data from some videos that have been uploaded to a YouTube channel.
It's data is based on search feature of Youtube.

## Features

- Create task to parse the channel videos :heavy_check_mark:
- Consult the list of created tasks :heavy_check_mark:
- Consult the data about the channel and it's videos :heavy_check_mark:

## Tech Stack

Used technologies to build the application

- Java
- Postgres
- Docker
- Docker Compose
- Github features (Issue, Pull Requests)

## Local Setup

To start the local application, only run the command below on the root

```bash
docker-compose up
```

It will run 2 containers: 

- Postgres database container (db) |  localhost:15432
- Java backend container (app) | localhost:8080

## API Endpoints


##### (POST) /api/tasks/{youtubeChannelId}

Example:

Request

```bash
http://localhost:8080/api/tasks/UCX6OQ3DkcsbYNE6H8uQQuVA
```

Response

```json
{
    "id": 1,
    "channelId": "UCX6OQ3DkcsbYNE6H8uQQuVA"
}
```
#

##### (GET) /api/tasks/

Example:

Request

```bash
http://localhost:8080/api/tasks/
```

Response

```json
[
    {
        "id": 1,
        "channelId": "UCX6OQ3DkcsbYNE6H8uQQuVA"
    },
    {
        "id": 2,
        "channelId": "UCX6OQ3DkcsbYNE6H8uQQuVA"
    }
]
```
#

##### (GET) /api/tasks/{taskId}

Example:

Request

```bash
http://localhost:8080/api/tasks/40
```

Response

```json
[
    {
        "id": 64,
        "videoId": "0e3GPea1Tyg",
        "title": "$456,000 Squid Game In Real Life!",
        "description": "MAKE SURE YOU WATCH UNTIL GLASS BRIDGE IT'S INSANE! Download Brawl Stars now and get a free gift from me in the ...",
        "channelId": "UCX6OQ3DkcsbYNE6H8uQQuVA",
        "channelTitle": "MrBeast",
        "thumbnailUrl": "https://i.ytimg.com/vi/0e3GPea1Tyg/hqdefault.jpg",
        "tasks": {
            "id": 40,
            "channelId": "UCX6OQ3DkcsbYNE6H8uQQuVA"
        }
    },
    {
        "id": 65,
        "videoId": "r7zJ8srwwjk",
        "title": "I Spent 50 Hours In Solitary Confinement",
        "description": "i borderline went crazy about 30 hours in... New Merch - https://shopmrbeast.com/ SUBSCRIBE OR I TAKE YOUR DOG ...",
        "channelId": "UCX6OQ3DkcsbYNE6H8uQQuVA",
        "channelTitle": "MrBeast",
        "thumbnailUrl": "https://i.ytimg.com/vi/r7zJ8srwwjk/hqdefault.jpg",
        "tasks": {
            "id": 40,
            "channelId": "UCX6OQ3DkcsbYNE6H8uQQuVA"
        }
    }
]
```

## Database Tables


### TB_VIDEO

| Fields                  |  Type        | Description |
| ----------------------- | :----------: | ----------: |
| id                      |  int         | Primary key |
| channel_id              | varchar(255) | Channel unique id generated by Youtube      |
| channel_title           | varchar(255) | Channel name           |
| description             | varchar(255) | Video description      |
| thumbnail_url           | varchar(255) | Thumbnail .jpg url     |
| title                   | varchar(255) | Video title            |
| tasks_id                |  int         | FK (TB_TASK)           |

### TB_TASK

| Fields                  |  Type        | Description |
| ----------------------- | :----------: | ----------: |
| id                      |  int         | Primary key |
| channel_id              | varchar(255) | Channel unique id generated by Youtube      |

## Author

 [<img src="https://github.com/KaiqueJuvencio.png" width="130px;"/><br /><sub>**Kaique Juvencio**</sub>](https://github.com/KaiqueJuvencio)<br /> 
