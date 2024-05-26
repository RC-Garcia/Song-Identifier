import asyncio
from shazamio import Shazam

async def identify_song(file_path):
    shazam = Shazam()
    out = await shazam.recognize_song(file_path)
    return out

if __name__ == "__main__":
    import sys
    file_path = input("Enter the path to the audio file: ")
    
    if not file_path:
        print("No file path provided.")
        sys.exit(1)
    
    loop = asyncio.get_event_loop()
    result = loop.run_until_complete(identify_song(file_path))
    
    if 'track' in result:
        song = result['track']
        print(f"Song identified: {song['title']} by {song['subtitle']}")
    else:
        print("Song could not be identified.")
