;;; Sierra Script 1.0 - (do not remove this comment)
(script# 800)
(include sci.sh)
(use Main)
(use LLRoom)
(use Door)
(use Class_255_0)
(use RandCycle)
(use Polygon)
(use CueObj)
(use n958)
(use Cycle)
(use PicView)
(use Obj)

(public
	rm800 0
)

(local
	local0
)
(instance rm800 of LLRoom
	(properties
		lookStr {You are outside the studios of `K-Rap Radio.' It appears to be an amazingly small building for a station of such importance.}
		picture 800
		north 820
	)
	
	(method (init)
		(proc958_0 128 800 810 571)
		(proc958_0 132 800 801 802 191 192)
		(super init:)
		(switch gGNumber
			(820
				(self style: 9)
				(gLarry
					init:
					normalize: 571
					posn: 153 143
					setHeading: 180
					edgeHit: 0
				)
				(gLongSong setVol: gGLongSongVol)
				(proc0_3)
			)
			(200
				(gLongSong stop:)
				(WrapMusic firstSound: 800 lastSound: 802 init:)
				(self style: 7)
				(self setScript: sExitLimo)
			)
			(else 
				(gLongSong stop:)
				(WrapMusic firstSound: 800 lastSound: 802 init:)
				(= gGLongSongVol (gLongSong vol?))
				(if (== global105 256)
					(self style: 9)
				else
					(self style: 8)
				)
				(gLarry
					init:
					normalize: 571
					posn: 155 153
					setHeading: 180
					edgeHit: 0
				)
				(proc0_3)
				(self setScript: exitDreamScript)
			)
		)
		(bush1 init:)
		(bush2 init:)
		(bush3 init:)
		(bush4 init:)
		(drumpicture init:)
		(tower init:)
		(tree1 init:)
		(limo init: approachVerbs: 3 4)
		(door init: openScript: sIntoBuilding)
		(neonSign init:)
		(cone1 init:)
		(cone2 init:)
		(gCast eachElementDo: #checkDetail)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						0
						0
						139
						0
						139
						144
						5
						147
						5
						153
						10
						156
						78
						156
						103
						153
						129
						152
						143
						162
						184
						162
						184
						154
						200
						151
						282
						149
						294
						148
						314
						144
						253
						143
						167
						143
						167
						0
						319
						0
						319
						189
						0
						189
					yourself:
				)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 820) (gLarry edgeHit: 1))
		(if gTheNewDialog (gTheNewDialog dispose:))
		(super newRoom: newRoomNumber)
	)
)

(instance limo of Feature
	(properties
		x 62
		y 161
		nsTop 148
		nsBottom 174
		nsRight 125
		description {your limousine}
		approachX 26
		approachY 152
		lookStr {Your limousine awaits your return.}
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(3
				(rm800 setScript: sEnterLimo)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance neonSign of Prop
	(properties
		x 156
		y 27
		description {the K-RAP sign}
		lookStr {High above your head, K-RAP's neon sign illuminates the Baltimore night.}
		view 800
		cel 8
		detailLevel 3
	)
	
	(method (init)
		(super init:)
		(self setCycle: Fwd checkDetail:)
	)
)

(instance door of Door
	(properties
		x 153
		y 138
		description {the door}
		approachX 153
		approachY 144
		lookStr {K-RAP's doors are always open.}
		view 800
		loop 1
		priority 9
		signal $0010
		entranceTo 820
		moveToX 153
		moveToY 140
		enterType 0
		exitType 0
	)
)

(instance cone1 of Prop
	(properties
		x 71
		y 118
		description {the left speaker}
		lookStr {K-RAP's loudspeakers broadcast the station's current programming.}
		view 800
		loop 2
		detailLevel 5
	)
	
	(method (init)
		(super init:)
		(self setCycle: RandCycle checkDetail:)
	)
)

(instance cone2 of Prop
	(properties
		x 235
		y 114
		description {the right speaker}
		lookStr {K-RAP's loudspeakers broadcast the station's current programming.}
		view 800
		loop 3
		detailLevel 5
	)
	
	(method (init)
		(super init:)
		(self setCycle: RandCycle checkDetail:)
	)
)

(instance bush1 of Feature
	(properties
		x 50
		y 136
		nsTop 125
		nsLeft 36
		nsBottom 147
		nsRight 64
		description {the bush}
		sightAngle 40
		lookStr {Someone planted these bushes right in the middle of this busy sidewalk!}
	)
)

(instance bush2 of Feature
	(properties
		x 107
		y 135
		nsTop 123
		nsLeft 89
		nsBottom 148
		nsRight 125
		description {the bush}
		sightAngle 40
		lookStr {Someone planted these bushes right in the middle of this busy sidewalk!}
	)
)

(instance bush3 of Feature
	(properties
		x 210
		y 134
		nsTop 117
		nsLeft 196
		nsBottom 151
		nsRight 224
		description {the bush}
		sightAngle 40
		lookStr {Someone planted these bushes right in the middle of this busy sidewalk!}
	)
)

(instance bush4 of Feature
	(properties
		x 283
		y 123
		nsTop 95
		nsLeft 268
		nsBottom 151
		nsRight 299
		description {the bush}
		sightAngle 40
		lookStr {Someone planted these bushes right in the middle of this busy sidewalk!}
	)
)

(instance drumpicture of Feature
	(properties
		x 161
		y 81
		nsTop 65
		nsLeft 112
		nsBottom 98
		nsRight 210
		description {the mural}
		sightAngle 40
		lookStr {K-RAP radio has a mural of musicians on their wall.}
	)
)

(instance tower of Feature
	(properties
		x 262
		y 36
		nsLeft 225
		nsBottom 90
		nsRight 303
		description {the tower}
		sightAngle 40
		lookStr {The tower holds the antennas that broadcast K-RAP's stereo multiplexed signal to millions of people (some of whom listen!).}
	)
)

(instance tree1 of Feature
	(properties
		x 24
		y 92
		nsTop 44
		nsBottom 141
		nsRight 49
		description {the trees}
		sightAngle 40
		lookStr {A clump of white birch trees grows just outside K-RAP.}
	)
)

(instance logo of Prop
	(properties
		x 164
		y 37
		view 810
		cel 12
		cycleSpeed 12
		detailLevel 3
	)
)

(instance city1 of Prop
	(properties
		x 38
		y 59
		view 810
		loop 2
		cycleSpeed 24
		detailLevel 5
	)
)

(instance city2 of Prop
	(properties
		x 193
		y 53
		view 810
		loop 3
		cycleSpeed 24
		detailLevel 5
	)
)

(instance plane of Actor
	(properties
		x 96
		y 13
		view 810
		loop 1
		moveSpeed 22
	)
)

(instance sIntoBuilding of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLarry hide:)
				(proc0_2)
				(gCast eachElementDo: #hide)
				(proc0_13 820)
				(if (not (proc0_6 26))
					(rm800 style: 7)
					(global2 drawPic: 810 picture: 810 curPic: 810)
					(logo init: setCycle: Fwd)
					(city1 init: setCycle: Fwd)
					(city2 init: setCycle: Fwd)
					(plane
						init:
						setCycle: Fwd
						setMotion: MoveTo -20 5
						setStep: 1 1
					)
					(gCast eachElementDo: #checkDetail)
					(proc0_7 26)
					(= seconds 5)
				else
					(global2 newRoom: 820)
				)
			)
			(1
				(proc0_14 800 0 67 -1 185 70 280 108 self)
			)
			(2 (= ticks 180))
			(3
				(proc0_14 800 1 67 -1 185 70 280 108 self)
			)
			(4 (= ticks 180))
			(5
				(proc0_14 800 2 67 -1 185 70 280 108 self)
			)
			(6 (= ticks 180))
			(7 (global2 newRoom: 820))
		)
	)
)

(instance exitDreamScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 6))
			(1
				(self dispose:)
				(if
					(proc255_0
						800
						3
						81
						{Save}
						1
						81
						{Nah, Why Bother?}
						0
						80
						{AL says}
						67
						-1
						20
					)
					(gGame save:)
				)
			)
		)
	)
)

(instance sExitLimo of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0 (= cycles 2))
			(1
				(proc0_2)
				(gLongSong2 number: 191 setLoop: 1 play:)
				(= ticks 50)
			)
			(2
				(gLarry
					init:
					normalize: 571
					posn: 26 174
					setHeading: 0
					edgeHit: 0
				)
				(= ticks 123)
			)
			(3
				(gLongSong2 number: 192 setLoop: 1 play:)
				(gLarry setMotion: MoveTo 26 152 self)
			)
			(4
				(proc0_3)
				(gLarry normalize: 571 setLoop: -1 setHeading: 0)
				(self dispose:)
			)
		)
	)
)

(instance sEnterLimo of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry setLoop: -1 setHeading: 180 self)
			)
			(1
				(gLarry setMotion: MoveTo 26 174 self)
			)
			(2
				(gLongSong2 number: 191 setLoop: 1 play:)
				(= ticks 50)
			)
			(3
				(gLarry hide:)
				(gLongSong2 number: 192 setLoop: 1 play:)
				(= ticks 100)
			)
			(4
				(gLongSong fade: 0 15 12 1)
				(global2 newRoom: 200)
			)
		)
	)
)
