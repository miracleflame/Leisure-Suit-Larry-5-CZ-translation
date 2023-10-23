;;; Sierra Script 1.0 - (do not remove this comment)
(script# 840)
(include sci.sh)
(use Main)
(use LLRoom)
(use Door)
(use Polygon)
(use CueObj)
(use ForwardCounter)
(use n958)
(use Sound)
(use Cycle)
(use PicView)
(use Obj)

(public
	rm840 0
)

(local
	local0
)
(instance rm840 of LLRoom
	(properties
		lookStr {John Krapper's Office is beautifully decorated in the latest high-tech look. Numerous halogen narrow-beam spotlights bathe the otherwise dark room with small brilliantly-white pools of light.}
		picture 840
		east 820
		west 850
	)
	
	(method (init)
		(proc958_0 128 840 841 842)
		(proc958_0 132 841 843 800 801 802)
		(proc958_0 130 969)
		(proc0_3)
		(gLarry init: normalize: (if (proc0_6 27) 842 else 570))
		(if (proc0_6 27) (gLarry actions: ActionsKRAP))
		(switch gGNumber
			(east
				(lobbyDoor setPri: 12)
				(gLarry
					posn: 268 152
					setHeading: 270
					edgeHit: 0
					observeControl: 2 4
				)
				(proc0_10 1 150)
			)
			(west
				(gLarry posn: 35 155 setHeading: 90 edgeHit: 0)
			)
			(else 
				(proc0_3)
				(gLarry posn: 160 160 edgeHit: 0)
			)
		)
		(super init:)
		(johnDoor init: approachVerbs: 3 4)
		(copier init: approachVerbs: 3 4 2 stopUpd:)
		(opener init: approachVerbs: 3)
		(table init:)
		(sofa init:)
		(chair init:)
		(lobbyDoor init: approachVerbs: 3 4 caller: rm840)
		(telephone init: approachVerbs: 2 3)
		(computer init: approachVerbs: 2 3)
		(stuff init:)
		(lamp1 init:)
		(lamp2 init:)
		(lamp3 init:)
		(lamp4 init:)
		(desk init: approachVerbs: 3 2 4)
		(plant init: approachVerbs: 3 4)
		(myWindow init:)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						0
						0
						319
						0
						319
						142
						268
						146
						267
						139
						255
						122
						235
						122
						226
						113
						92
						113
						79
						113
						96
						119
						96
						133
						70
						139
						52
						147
						33
						147
						0
						139
					yourself:
				)
				((Polygon new:)
					type: 2
					init:
						0
						155
						33
						155
						4
						173
						3
						187
						316
						187
						316
						180
						282
						156
						319
						156
						319
						189
						0
						189
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 101 116 220 116 225 127 108 127
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 71 142 148 129 176 134 176 141 119 151 147 164 147 173 84 184 74 165
					yourself:
				)
				((Polygon new:)
					type: 2
					init:
						148
						155
						160
						149
						175
						149
						208
						149
						218
						151
						239
						158
						237
						165
						228
						170
						161
						168
						148
						161
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 211 141 245 135 262 144 268 155 238 155 218 148
					yourself:
				)
		)
		(if (== gGNumber east) (proc0_14 840 0))
		(gLl5MDHandler add: self)
		(gLl5KDHandler add: self)
	)
	
	(method (dispose)
		(proc958_0 0 969)
		(gLl5MDHandler delete: self)
		(gLl5KDHandler delete: self)
		(ActionsKRAP dispose:)
		(super dispose:)
	)
	
	(method (cue)
		(lobbyDoor ignoreActors:)
		(lobbyDoor caller: 0)
	)
)

(instance desk of Feature
	(properties
		x 150
		y 115
		nsTop 90
		nsLeft 113
		nsBottom 126
		nsRight 214
		description {the desk}
		sightAngle 40
		approachX 150
		approachY 112
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(cond 
					((not (proc0_6 24))
						(proc0_14 840 1)
						(if (not (gLarry has: 8))
							(proc0_14 840 2)
						else
							(proc0_14 840 3)
						)
					)
					((not (proc0_6 25)) (proc0_7 25) (gLarry setScript: lookDeskScript))
					((not (gLarry has: 10)) (gLarry get: 10) (gLarry setScript: lookPapersScript))
					(else (gLarry setScript: sLookDesk2ndTime))
				)
			)
			(3
				(cond 
					(
					(and (not (gLarry has: 8)) (not (proc0_6 24)))
						(proc0_10 4 149)
						(proc0_14 840 4)
						(opener hide:)
						(gLarry get: 8)
					)
					((not (proc0_6 24)) (proc0_14 840 5))
					((and (proc0_6 24) (not (proc0_6 25))) (proc0_7 25) (gLarry setScript: openDeskScript))
					((and (proc0_6 25) (not (gLarry has: 10))) (gLarry get: 10) (gLarry setScript: getPapersScript))
					(else (gLarry setScript: sOpenDesk2ndTime))
				)
			)
			(4
				(switch param2
					(8
						(if (proc0_6 24)
							(proc0_14 840 6)
							(gLarry put: 8)
							(opener show:)
							(proc0_8 24)
						else
							(proc0_7 24)
							(gLarry setScript: pickLockScript)
						)
					)
					(9
						(if (proc0_6 24)
							(proc0_8 24)
							(gLarry setScript: lockDeskScript)
						else
							(proc0_7 24)
							(gLarry setScript: unlockDeskScript)
						)
					)
					(10
						(if (proc0_6 24)
							(gLarry put: 10)
							(gLarry setScript: putPapersScript)
						else
							(proc0_14 840 7)
						)
					)
					(else 
						(super doVerb: theVerb param2 &rest)
					)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance plant of Feature
	(properties
		x 248
		y 81
		nsTop 40
		nsLeft 208
		nsBottom 122
		nsRight 290
		description {the potted plant}
		sightAngle 40
		approachX 231
		approachY 120
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(cond 
					((gLarry has: 9) (proc0_14 840 8))
					((proc0_6 23) (proc0_14 840 9))
					(else (proc0_14 840 10) (proc0_7 23))
				)
			)
			(3
				(if (not (gLarry has: 9))
					(if (proc0_6 23)
						(gLarry setScript: getKeyScript)
					else
						(gLarry setScript: sPawThruPlant)
					)
				else
					(super doVerb: theVerb param2 &rest)
				)
			)
			(4
				(if (== param2 9)
					(gLarry put: 9)
					(gLarry setScript: replaceKeyScript)
				else
					(super doVerb: theVerb param2 &rest)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance copier of Prop
	(properties
		x 58
		y 138
		z 20
		description {the copier}
		approachX 68
		approachY 138
		lookStr {It's a genuine ZeroZ 9000, the latest in personal copiers.}
		view 840
		loop 3
		priority 10
		signal $0010
		cycleSpeed 18
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(if (gLarry has: 11)
					(proc0_14 840 11)
				else
					(proc0_14 840 12)
				)
			)
			(4
				(switch param2
					(10
						(if (gLarry has: 11)
							(proc0_14 840 11)
						else
							(gLarry setScript: runCopierScript)
						)
					)
					(else 
						(super doVerb: theVerb param2 &rest)
					)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance paper of Prop
	(properties
		x 58
		y 112
		description {the copier}
		approachX 68
		approachY 138
		lookStr {It's a genuine ZeroZ 9000, the latest in personal copiers.}
		view 840
		loop 5
		priority 10
		signal $0010
		cycleSpeed 12
	)
)

(instance johnDoor of Door
	(properties
		x 11
		y 153
		description {the bathroom door}
		approachX 44
		approachY 152
		lookStr {A sign on the door says "Krapper's Crapper." A smaller sign below it says "John's John".}
		view 840
		loop 1
		signal $4000
		entranceTo 850
		moveToY 141
		enterType 0
		exitType 0
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(cond 
					((gLarry has: 10) (proc0_14 840 13))
					((gLarry has: 9) (proc0_14 840 14))
					((gLarry has: 8) (proc0_14 840 15))
					(else
						(gLarry ignoreControl: 4)
						(self setPri: 15)
						(super doVerb: theVerb param2 &rest)
					)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (close)
		(gLarry observeControl: 4 2)
		(super close:)
	)
)

(instance lobbyDoor of Door
	(properties
		x 302
		y 153
		description {the lobby door}
		approachX 269
		approachY 159
		lookStr {This is the door through which you entered. If you walked out it, you would return to the lobby.}
		view 840
		loop 2
		signal $4000
		entranceTo 820
		moveToX 280
		moveToY 150
		enterType 0
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(gLarry setScript: peekScript)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (close)
		(self setPri: -1)
		(super close:)
	)
)

(instance table of Feature
	(properties
		x 192
		y 157
		nsTop 149
		nsLeft 152
		nsBottom 165
		nsRight 232
		description {the table}
		sightAngle 40
		lookStr {Krapper has a beautiful glass coffee table.}
	)
)

(instance chair of Feature
	(properties
		x 237
		y 139
		nsTop 120
		nsLeft 222
		nsBottom 152
		nsRight 256
		description {the chair}
		sightAngle 40
		lookStr {This is the kind of furniture you would buy if you ever settled down.}
	)
)

(instance sofa of Feature
	(properties
		x 112
		y 153
		nsTop 126
		nsLeft 83
		nsBottom 178
		nsRight 141
		description {the sofa}
		sightAngle 40
		lookStr {What an unusual sofa! You so love modern furniture.}
	)
)

(instance telephone of Feature
	(properties
		x 194
		y 116
		z 20
		nsTop 96
		nsLeft 187
		nsBottom 106
		nsRight 202
		description {the telephone}
		sightAngle 40
		approachX 200
		approachY 112
		lookStr {John Krapper's telephone has very few buttons. He must be REALLY important!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 840 16))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance computer of Feature
	(properties
		x 137
		y 116
		z 20
		nsTop 88
		nsLeft 127
		nsBottom 105
		nsRight 148
		description {the desk computer}
		sightAngle 40
		approachX 140
		approachY 112
		lookStr {Look at the dust on that keyboard! He must never use his computer!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 840 17))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance myWindow of Feature
	(properties
		x 161
		y 73
		nsTop 39
		nsLeft 66
		nsBottom 107
		nsRight 256
		description {the window}
		sightAngle 40
		lookStr {Krapper's office has a giant window looking out over beautiful downtown Philadelphia.}
	)
)

(instance stuff of Feature
	(properties
		x 53
		y 72
		nsTop 43
		nsLeft 33
		nsBottom 102
		nsRight 73
		description {the shelves}
		sightAngle 40
		lookStr {Krapper's bookcase is filled with items, all of them useless to your mission.}
	)
)

(instance lamp1 of Feature
	(properties
		x 59
		y 23
		nsTop 17
		nsLeft 53
		nsBottom 29
		nsRight 65
		description {the lamp}
		sightAngle 40
		lookStr {The small halogen spotlights cast a pure white light.}
	)
)

(instance lamp2 of Feature
	(properties
		x 99
		y 6
		nsLeft 93
		nsBottom 13
		nsRight 106
		description {the lamp}
		sightAngle 40
		lookStr {The small halogen spotlights cast a pure white light.}
	)
)

(instance lamp3 of Feature
	(properties
		x 163
		y 22
		nsTop 18
		nsLeft 158
		nsBottom 26
		nsRight 169
		description {the lamp}
		sightAngle 40
		lookStr {The small halogen spotlights cast a pure white light.}
	)
)

(instance lamp4 of Feature
	(properties
		x 260
		y 24
		nsTop 20
		nsLeft 253
		nsBottom 29
		nsRight 267
		description {the lamp}
		sightAngle 40
		lookStr {The small halogen spotlights cast a pure white light.}
	)
)

(instance opener of View
	(properties
		x 155
		y 105
		description {the letter opener}
		approachX 187
		approachY 118
		view 840
		priority 9
		signal $0010
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 840 18))
			(3
				(proc0_14 840 4)
				(opener hide:)
				(gLarry get: 8)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance copyMachineSound of Sound
	(properties
		flags $0001
		number 841
		priority 11
	)
)

(instance copyExplodesSound of Sound
	(properties
		flags $0001
		number 842
		priority 11
	)
)

(instance pickLockSound of Sound
	(properties
		flags $0001
		number 843
		priority 11
	)
)

(instance peekScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(lobbyDoor setCel: 1)
				(gLarry setMotion: MoveTo 272 150 self)
			)
			(1
				(gLarry setLoop: 8 setCel: 0)
				(= seconds 3)
			)
			(2
				(proc0_14 840 19)
				(= seconds 3)
			)
			(3
				(lobbyDoor setCel: 0)
				(gLarry
					normalize: (if (proc0_6 27) 842 else 570)
					observeControl: 2 4
					setScript: 0
				)
				(proc0_3)
			)
		)
	)
)

(instance getKeyScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry
					view: 841
					loop: (if (proc0_6 27) 7 else 2)
					setCel: 0
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(1
				(gLarry
					normalize: (if (proc0_6 27) 842 else 570)
					observeControl: 2 4
					get: 9
					setHeading: 90
				)
				(= ticks 30)
			)
			(2
				(proc0_10 10 148)
				(proc0_14 840 20 67 -1 20)
				(proc0_3)
				(gLarry setScript: 0)
			)
		)
	)
)

(instance sPawThruPlant of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry
					view: 841
					loop: (if (proc0_6 27) 7 else 2)
					setCel: 0
					cycleSpeed: 18
					setCycle: CT 5 1 self
				)
			)
			(1
				(gLarry setCycle: CT 0 -1 self)
			)
			(2
				(gLarry
					normalize: (if (proc0_6 27) 842 else 570)
					setHeading: 90
				)
				(= ticks 30)
			)
			(3
				(proc0_14 840 21)
				(proc0_7 23)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance replaceKeyScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry
					view: 841
					loop: (if (proc0_6 27) 7 else 2)
					setCel: 255
					cycleSpeed: 18
					setCycle: Beg self
				)
			)
			(1
				(gLarry
					normalize: (if (proc0_6 27) 842 else 570)
					observeControl: 2 4
					setHeading: 90
				)
				(= ticks 30)
			)
			(2
				(proc0_14 840 22 67 -1 20)
				(proc0_3)
				(gLarry setScript: 0)
			)
		)
	)
)

(instance openDeskScript of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 100])
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry
					view: 841
					loop: (if (proc0_6 27) 6 else 0)
					setCel: 0
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(1 (= ticks 123))
			(2
				(gLarry setCel: 255 setCycle: Beg self)
			)
			(3 (= ticks 123))
			(4
				(Format @temp0 840 23 (= global171 (Random 10000 -536)))
				(proc0_10 4 144)
				(proc0_14 @temp0)
				(gLarry
					normalize: (if (proc0_6 27) 842 else 570)
					observeControl: 2 4
					loop: 2
					setHeading: 180
					setScript: 0
				)
				(proc0_3)
			)
		)
	)
)

(instance sOpenDesk2ndTime of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 100])
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry
					view: 841
					loop: (if (proc0_6 27) 6 else 0)
					setCel: 0
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(1 (= ticks 123))
			(2
				(gLarry setCel: 255 setCycle: Beg self)
			)
			(3 (= ticks 123))
			(4
				(Format @temp0 840 24 global171)
				(proc0_14 @temp0)
				(gLarry
					normalize: (if (proc0_6 27) 842 else 570)
					observeControl: 2 4
					setHeading: 180
					loop: 2
					setScript: 0
				)
				(proc0_3)
			)
		)
	)
)

(instance lookDeskScript of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 100])
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry
					view: 841
					loop: (if (proc0_6 27) 6 else 0)
					cycleSpeed: 18
					setCel: 0
					setCycle: End self
				)
			)
			(1 (= ticks 123))
			(2
				(gLarry setCel: 255 setCycle: Beg self)
			)
			(3 (= ticks 123))
			(4
				(Format @temp0 840 23 (= global171 (Random 10000 -536)))
				(proc0_10 5 144)
				(proc0_14 @temp0)
				(gLarry
					normalize: (if (proc0_6 27) 842 else 570)
					observeControl: 2 4
					loop: 2
					setHeading: 180
					setScript: 0
				)
				(proc0_3)
			)
		)
	)
)

(instance sLookDesk2ndTime of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 100])
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry
					view: 841
					loop: (if (proc0_6 27) 6 else 0)
					setCel: 0
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(1 (= ticks 123))
			(2
				(gLarry setCel: 255 setCycle: Beg self)
			)
			(3 (= ticks 123))
			(4
				(Format @temp0 840 24 global171)
				(proc0_14 @temp0)
				(gLarry
					normalize: (if (proc0_6 27) 842 else 570)
					observeControl: 2 4
					loop: 2
					setHeading: 180
					setScript: 0
				)
				(proc0_3)
			)
		)
	)
)

(instance pickLockScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry
					view: 841
					loop: (if (proc0_6 27) 6 else 0)
					setCel: 0
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(1
				(pickLockSound play:)
				(gLarry setCel: 255 setCycle: Beg self)
			)
			(2
				(proc0_10 5 147)
				(proc0_14 840 25)
				(gLarry
					normalize: (if (proc0_6 27) 842 else 570)
					observeControl: 2 4
					loop: 2
					setHeading: 180
					setScript: 0
				)
				(proc0_3)
			)
		)
	)
)

(instance unlockDeskScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry
					view: 841
					loop: (if (proc0_6 27) 6 else 0)
					setCel: 0
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(1
				(pickLockSound play:)
				(gLarry setCel: 255 setCycle: Beg self)
			)
			(2
				(proc0_10 13 147)
				(proc0_14 840 26)
				(gLarry
					normalize: (if (proc0_6 27) 842 else 570)
					observeControl: 2 4
					loop: 2
					setHeading: 180
					setScript: 0
				)
				(proc0_3)
			)
		)
	)
)

(instance lockDeskScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry
					view: 841
					loop: (if (proc0_6 27) 6 else 0)
					setCel: 0
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(1
				(pickLockSound play:)
				(gLarry setCel: 255 setCycle: Beg self)
			)
			(2
				(proc0_14 840 27)
				(gLarry
					normalize: (if (proc0_6 27) 842 else 570)
					observeControl: 2 4
					loop: 2
					setHeading: 180
					setScript: 0
				)
				(proc0_3)
			)
		)
	)
)

(instance getPapersScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry
					view: 841
					loop: (if (proc0_6 27) 6 else 0)
					setCel: 0
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(1
				(gLarry
					view: 841
					loop: (if (proc0_6 27) 8 else 1)
					setCel: 0
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(2 (= ticks 123))
			(3
				(proc0_10 5 145)
				(proc0_14 840 28)
				(gLarry
					normalize: (if (proc0_6 27) 842 else 570)
					observeControl: 2 4
					loop: 2
					setHeading: 180
					setScript: 0
				)
				(proc0_3)
			)
		)
	)
)

(instance lookPapersScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry
					view: 841
					loop: (if (proc0_6 27) 8 else 1)
					setCel: 255
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(1
				(proc0_14 840 29)
				(= ticks 60)
			)
			(2
				(proc0_14 840 30)
				(= ticks 60)
			)
			(3
				(proc0_10 5 145)
				(proc0_14 840 31)
				(= ticks 123)
			)
			(4
				(gLarry
					normalize: (if (proc0_6 27) 842 else 570)
					observeControl: 2 4
					loop: 2
					setHeading: 180
					setScript: 0
				)
				(proc0_3)
			)
		)
	)
)

(instance putPapersScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry
					view: 841
					setLoop: (if (proc0_6 27) 8 else 1)
					setCel: 255
					cycleSpeed: 18
					setCycle: Beg self
				)
			)
			(1 (= seconds 3))
			(2
				(gLarry
					loop: (if (proc0_6 27) 6 else 0)
					setCel: 255
					cycleSpeed: 18
					setCycle: Beg self
				)
			)
			(3 (= ticks 60))
			(4
				(proc0_14 840 32)
				(gLarry
					normalize: (if (proc0_6 27) 842 else 570)
					observeControl: 2 4
					loop: 2
					setHeading: 180
					setScript: 0
				)
				(proc0_3)
			)
		)
	)
)

(instance runCopierScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry
					view: 841
					loop: 3
					cycleSpeed: 18
					x: 68
					y: 138
					setCycle: End self
				)
			)
			(1
				(gLarry loop: 4 setCel: 255 setCycle: Beg self)
			)
			(2
				(proc0_10 12 151)
				(proc0_14 840 33)
				(= ticks 123)
			)
			(3
				(gLarry loop: 4 setCycle: End self)
			)
			(4
				(copyMachineSound play: setLoop: -1)
				(copier setCel: 0 setCycle: End self setPri: 9)
			)
			(5
				(copier stopUpd:)
				(= cycles 1)
			)
			(6
				(paper
					init:
					setCel: 0
					setPri: 9
					setCycle: ForwardCounter 5 self
				)
			)
			(7
				(copyMachineSound stop:)
				(= ticks 200)
			)
			(8
				(proc0_18 gLarry 840 34)
				(= seconds 3)
			)
			(9
				(gLarry loop: 3 setCel: 255 setCycle: Beg self)
			)
			(10
				(paper dispose:)
				(copier setCel: 0)
				(proc0_18 gLarry 840 35)
				(= seconds 3)
			)
			(11
				(gLarry loop: 4 setCel: 0 setCycle: End self)
			)
			(12
				(proc0_18 gLarry 840 36)
				(= ticks 123)
			)
			(13
				(proc0_14 840 37 67 -1 185)
				(= ticks 60)
			)
			(14
				(gLarry loop: 4 setCel: 255 setCycle: Beg self)
			)
			(15
				(gLarry
					normalize: 570
					x: 69
					y: 140
					loop: 1
					setHeading: 270
				)
				(= ticks 60)
			)
			(16
				(copyExplodesSound play:)
				(copier
					view: 840
					startUpd:
					cycleSpeed: 12
					setCel: 0
					setLoop: 4
					setCycle: CT 1 1 self
				)
			)
			(17
				(gLarry
					normalize: 842
					observeControl: 2 4
					loop: 1
					setHeading: 270
				)
				(copier view: 840 setPri: 11 setCycle: CT 4 1 self)
			)
			(18
				(copier view: 840 setPri: 9 setCycle: End self)
			)
			(19 (= seconds 3))
			(20
				(proc0_18 gLarry 840 38)
				(copier stopUpd:)
				(proc0_7 27)
				(gLarry get: 11 actions: ActionsKRAP setScript: 0)
				(proc0_3)
			)
		)
	)
)

(instance ActionsKRAP of Actions
	(properties)
	
	(method (doit)
		(return 0)
	)
	
	(method (doVerb theVerb)
		(return
			(switch theVerb
				(2
					(if (== (gLarry view?) 842)
						(proc0_14 840 39)
						(return 1)
					else
						(proc0_14 840 40)
						(return 1)
					)
				)
				(else  (return 0))
			)
		)
	)
)
