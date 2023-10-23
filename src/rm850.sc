;;; Sierra Script 1.0 - (do not remove this comment)
(script# 850)
(include sci.sh)
(use Main)
(use LLRoom)
(use Door)
(use Polygon)
(use CueObj)
(use n958)
(use Sound)
(use Cycle)
(use InvI)
(use PicView)
(use Obj)

(public
	rm850 0
)

(local
	local0
)
(instance rm850 of LLRoom
	(properties
		lookStr {John Krapper's bathroom lives up to expectations. Gold fixtures are scattered everywhere. There are even a pair of gold statuettes on either side of the "crapper."}
		picture 850
		east 840
	)
	
	(method (init)
		(proc958_0 128 850 851 842)
		(proc958_0 132 851 852 853 800 801 802)
		(proc0_3)
		(gLarry init: normalize: (if (proc0_6 27) 842 else 570))
		(if (proc0_6 27) (gLarry actions: ActionsKRAP))
		(gLarry posn: 270 140 setHeading: 270 edgeHit: 0)
		(super init:)
		(officeDoor init:)
		(sDoor init: approachVerbs: 3 ignoreActors: stopUpd:)
		(shower init: approachVerbs: 3 ignoreActors: stopUpd:)
		(showerSide init: approachVerbs: 3 ignoreActors: stopUpd:)
		(toilet init: approachVerbs: 3 10 2 4)
		(myWindow init:)
		(curtain1 init:)
		(curtain2 init:)
		(sink1 init:)
		(sink2 init:)
		(skylight init:)
		(rightStatue init:)
		(leftStatue init:)
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
						123
						272
						130
						247
						111
						240
						111
						240
						128
						83
						128
						77
						112
						63
						112
						52
						121
						59
						128
						59
						138
						51
						145
						32
						152
						6
						146
						4
						186
						54
						186
						61
						177
						89
						177
						112
						165
						145
						165
						139
						177
						173
						177
						172
						165
						207
						165
						217
						177
						249
						178
						256
						187
						317
						187
						314
						162
						283
						136
						318
						131
						319
						189
						0
						189
					yourself:
				)
		)
		(gLl5MDHandler add: self)
		(gLl5KDHandler add: self)
	)
	
	(method (dispose)
		(gLl5MDHandler delete: self)
		(gLl5KDHandler delete: self)
		(ActionsKRAP dispose:)
		(super dispose:)
	)
)

(instance shower of Actor
	(properties
		x 25
		y 144
		description {the shower}
		sightAngle 40
		approachX 73
		approachY 139
		lookStr {What appears to be a lovely glass shower rests against the wall.}
		view 850
		priority 8
		signal $4010
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(if (proc0_6 27)
					(gLarry setScript: TakeAShowerScript)
				else
					(proc0_14 850 0)
					(proc0_14 850 1 67 -1 185)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance showerSide of Actor
	(properties
		x 26
		y 144
		description {the shower}
		sightAngle 40
		approachX 73
		approachY 139
		lookStr {Why, look! A lovely glass shower stands against the wall.}
		view 850
		cel 1
	)
	
	(method (doVerb theVerb param2)
		(shower doVerb: theVerb param2 &rest)
	)
)

(instance officeDoor of Door
	(properties
		x 298
		y 136
		description {the office door}
		approachX 264
		approachY 136
		lookStr {This door leads back to John Krapper's office.}
		view 850
		loop 1
		priority 10
		signal $4010
		entranceTo 840
		moveToX 306
		moveToY 127
		enterType 0
		exitType 0
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(gLarry ignoreControl: 2)
				(super doVerb: theVerb param2 &rest)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (close)
		(gLarry observeControl: 2)
		(super close:)
	)
)

(instance sDoor of Actor
	(properties
		x 26
		y 144
		description {the shower}
		approachX 73
		approachY 139
		view 850
		loop 2
	)
	
	(method (doVerb theVerb param2)
		(shower doVerb: theVerb param2 &rest)
	)
)

(instance toilet of Feature
	(properties
		x 155
		y 183
		nsTop 178
		nsLeft 134
		nsBottom 189
		nsRight 177
		description {Krapper's crapper}
		sightAngle 40
		approachX 161
		approachY 180
		lookStr {Made of hand-carved, gold-flecked marble with a gold-plated handle and ermine-covered seat, it's obvious to you this guy really knows his "K-RAP!"}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(proc0_14 850 2)
				(flushSound play:)
			)
			(10
				(proc0_14 850 2)
				(flushSound play:)
			)
			(2
				(super doVerb: theVerb param2 &rest)
			)
			(4
				(switch param2
					(11 (proc0_14 850 3))
					(else  (proc0_14 850 4))
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance myWindow of Feature
	(properties
		x 148
		y 80
		nsTop 46
		nsLeft 78
		nsBottom 114
		nsRight 219
		description {the window}
		sightAngle 40
		lookStr {A giant plate-glass window looks out over the lovely glow of downtown Philadelphia at night.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance curtain1 of Feature
	(properties
		x 68
		y 79
		nsTop 48
		nsLeft 59
		nsBottom 111
		nsRight 78
		description {the curtains}
		sightAngle 40
		lookStr {These curtains are only for show; they do not close.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance curtain2 of Feature
	(properties
		x 231
		y 77
		nsTop 43
		nsLeft 221
		nsBottom 112
		nsRight 242
		description {the curtains}
		sightAngle 40
		lookStr {These curtains are only for show; they do not close.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance sink1 of Feature
	(properties
		x 117
		y 110
		nsTop 96
		nsLeft 91
		nsBottom 125
		nsRight 143
		description {the left sink}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 850 5))
			(3
				(if (proc0_6 27)
					(proc0_14 850 6)
				else
					(proc0_14 850 7)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance sink2 of Feature
	(properties
		x 204
		y 110
		nsTop 96
		nsLeft 176
		nsBottom 124
		nsRight 233
		description {the right sink}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(sink1 doVerb: theVerb param2 &rest)
			)
			(3
				(sink1 doVerb: theVerb param2 &rest)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance skylight of Feature
	(properties
		x 155
		y 14
		nsTop 4
		nsLeft 91
		nsBottom 25
		nsRight 219
		description {the skylight}
		sightAngle 40
		lookStr {The ceiling of John Krapper's bathroom is crowned by a lovely skylight.}
	)
)

(instance rightStatue of Feature
	(properties
		x 118
		y 145
		nsTop 127
		nsLeft 107
		nsBottom 163
		nsRight 129
		description {the statuette}
		lookStr {This statuette was presented to K-RAP Radio for excellence in broadcasting!}
	)
)

(instance leftStatue of Feature
	(properties
		x 197
		y 148
		nsTop 130
		nsLeft 187
		nsBottom 167
		nsRight 207
		description {the statuette}
		lookStr {This statuette was presented to K-RAP Radio for excellence in broadcasting!}
	)
)

(instance clothes of View
	(properties
		x 40
		y 141
		view 850
		cel 2
	)
)

(instance flushSound of Sound
	(properties
		number 851
		priority 11
	)
)

(instance runWaterSound of Sound
	(properties
		number 852
		priority 11
	)
)

(instance TakeAShowerScript of Script
	(properties)
	
	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(proc0_2)
				(proc0_10 7)
				(proc0_14 850 8)
				(sDoor setCycle: End self)
			)
			(1
				(gLarry setMotion: MoveTo 29 139 self)
				(shower startUpd:)
				(showerSide startUpd:)
			)
			(2
				(gLarry
					cycleSpeed: 12
					view: 851
					loop: 2
					setCycle: End self
				)
			)
			(3
				(sDoor cel: 0)
				(gLarry setLoop: 3 setCycle: End self)
				(clothes init:)
			)
			(4
				(proc0_14 850 9)
				(gLongSong2 number: 853 play: hold: 10)
				(sDoor setPri: 1 setMotion: MoveTo 26 226 self)
				(gLarry
					setPri: 0
					setMotion: MoveTo 29 226 self
					moveSpeed: 6
				)
				(shower setPri: 1 setMotion: MoveTo 25 226 self)
				(showerSide setPri: 1 setMotion: MoveTo 26 226 self)
			)
			(5
				(= temp0 0)
				(while (< temp0 (Inv size?))
					(if ((= temp1 (Inv at: temp0)) ownedBy: 24)
						(temp1 owner: 1000)
					)
					(++ temp0)
				)
				(proc0_14 850 10)
				(proc0_14 850 11)
				(global2 newRoom: 860)
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
						(proc0_18 gLarry 850 12)
						(return 1)
					else
						(proc0_14 850 13)
						(return 1)
					)
				)
				(else  (return 0))
			)
		)
	)
)
