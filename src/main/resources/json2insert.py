#!/usr/local/bin/python
# -*- coding: utf-8 -*-
# Скрипт конверсии вороха JSONов с описанием перемещений персонажей в простыню INSERTов.

import os, glob, json

def generate_sql_insert_script(fileList):
    houses = {}
    houseIdIndex = 1

    names = []
    namesIdIndex = 1

    waypoints = []
    waypointIdIndex = 1

    characterIdIndex = 1

    for jsonFile in fileList:
        with open(jsonFile, 'r') as f:
            content = json.loads(f.read())
            if not houses.get(content['house']):
                houses.update({content['house']: houseIdIndex})
                houseIdIndex += 1
            names.append("INSERT INTO characters(id, first_name, last_name, house_id) VALUES(%d, '%s', '%s', %d);" % (
            characterIdIndex,
            content["name"].split()[0],
            content["name"].split()[1],
            houses.get(content["house"])
            )
            )
            characterIdIndex += 1

            for waypoint in content["wayPoints"]:
                waypoints.append("INSERT INTO character_movements(id, delay_millis, velocity, x, y, character_id) VALUES(%d, %d, %d, %.2f, %.2f, %d);" % (
                waypointIdIndex,
                waypoint['delayMillis'],
                waypoint['velocity'],
                waypoint['x'],
                waypoint['y'],
                namesIdIndex
                )
                )
                waypointIdIndex += 1
            namesIdIndex += 1


    houseList = []
    for house in houses.items():
        houseList.append("INSERT INTO houses(id, name) VALUES(%d, '%s');" % (house[1], house[0]))

    return "\n".join(houseList) + "\n" + "\n".join(names) + "\n" + "\n".join(waypoints)


if __name__ == '__main__':
    files = glob.glob('*.json')
    if len(files) == 0:
        print('No JSONs found. Aborting.')
        sys.exit(0)
    print generate_sql_insert_script(files)
