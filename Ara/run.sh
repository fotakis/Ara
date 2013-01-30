#!/bin/sh

java -cp $(echo $(find target/dependency -type f | sed 's/$/:/g')target/Ara-1.0-SNAPSHOT.jar | sed -e 's/ //g') makesense.ara.Ara $@

