import json

print("CONFIGYR PROJET VALIDATOR VERSION 0.1.0 BY TART")

targetFile = input("Input path of file to validate: ")

with open(targetFile) as f:
    fileData = json.load(f)

# print("Type:", type(fileData) # DEBUG

currentVersion = "0.1.0"

projectVersion = fileData.get('version')
projectName = fileData.get('projectName')
projectPath = fileData.get('voicebankPath')
parameterPath = fileData.get('paramFilePath')

if (projectVersion != currentVersion):
    print("Out of date project version. Please update to version " + currentVersion)
else:
    print("Project has up to date version.")

if (len(projectName) == 0):
    print("The project name is null. Please repair file.")
else:
    print("Project has a valid name.")

if (len(projectPath) == 0):
    print("The project path is null. Please repair file.")
else:
    print("Project has a valid path.")

if (len(parameterPath) == 0):
    print("The parameter path is null. Please repair file.")
else:
    print("Project has a valid parameter file path.")