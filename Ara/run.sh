#!/bin/sh

curr_pwd=${PWD}
cd $(dirname $0)
script_pwd=${PWD}

java -cp $(echo $(find target/dependency -type f | sed 's/$/:/g')target/Ara-1.0-SNAPSHOT.jar | sed -e 's/ //g') makesense.ara.Ara $@

cd $curr_pwd

