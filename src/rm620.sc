;;; Sierra Script 1.0 - (do not remove this comment)
(script# 620)
(include sci.sh)
(use Main)
(use LLRoom)
(use RTRandCycle)
(use Polygon)
(use CueObj)
(use ForwardCounter)
(use n958)
(use Sound)
(use Cycle)
(use InvI)
(use User)
(use PicView)
(use Obj)

(public
	rm620 0
)

(local
	local0
	local1
	local2
	local3
	local4
)
(instance rm620 of LLRoom
	(properties
		picture 620
		north 640
		south 600
	)
	
	(method (init)
		(gLarry init: normalize: 570)
		(proc0_3)
		(switch gGNumber
			(south
				(gLarry x: 92)
				(gLongSong number: 620 flags: 1 setLoop: -1 play:)
			)
			(north
				(gLarry setPri: 9 posn: 57 141)
				(global2 setScript: sExitElevator)
			)
			(else 
				(gLarry posn: 160 160 edgeHit: 0)
				(gLongSong number: 620 flags: 1 setLoop: -1 play:)
			)
		)
		(proc958_0 129 630)
		(proc958_0 132 621 622)
		(super init:)
		(board init: approachVerbs: 2 3 4)
		(guard init: approachVerbs: 5 4 3)
		(elevator init: approachVerbs: 3 4)
		(elevatorLeft init: approachVerbs: 3 4)
		(plant init:)
		(mural init:)
		(fStairs init:)
		(fLamp1 init:)
		(fLamp2 init:)
		(fAshtray init: approachVerbs: 2 3)
		(sconceA init:)
		(sconceB init:)
		(clock init:)
		(breasts init:)
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
						189
						123
						189
						123
						187
						313
						187
						313
						159
						224
						159
						203
						155
						198
						145
						197
						137
						209
						130
						313
						130
						313
						116
						136
						116
						132
						119
						122
						120
						114
						120
						61
						150
						61
						151
						62
						158
						58
						163
						51
						164
						16
						189
						0
						189
					yourself:
				)
		)
	)
	
	(method (doit)
		(if (and (gLarry edgeHit?) (== local0 1))
			(= local0 0)
			(guard
				setLoop: 0
				setCel: 0
				cycleSpeed: 30
				setCycle: End self
			)
		)
		(super doit:)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1
				(if (== curPic 630)
					(global2 setScript: sReturnsFromBoard)
					1
				)
			)
			(2
				(if (== curPic 630)
					(proc0_14 620 0)
				else
					(proc0_14 620 1)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(if (not (== newRoomNumber 640))
			(gLongSong fade: 0 15 12 1)
		)
	)
)

(instance sExitElevator of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_2) (= seconds 2))
			(1
				(elevatorDing play:)
				(= cycles 10)
			)
			(2
				(elevatorDoor play:)
				(elevatorLeft setCycle: End)
				(elevator setCycle: End self)
			)
			(3
				(elevatorDoor stop:)
				(gLarry setMotion: MoveTo 89 150 self)
			)
			(4 (= seconds 2))
			(5
				(gLarry setPri: -1)
				(elevatorDoor play:)
				(elevatorLeft setCycle: Beg)
				(elevator setCycle: Beg self)
			)
			(6
				(elevatorDoor stop:)
				(elevator stopUpd: 1)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance sGuardWakes of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(guard
					setLoop: 0
					setCel: (guard lastCel:)
					cycleSpeed: 12
					setCycle: Beg self
				)
			)
			(1
				(= local0 1)
				(proc0_18 The_Guard 620 2 108)
				(proc0_3)
				(proc0_17 6 2 self)
			)
			(2
				(proc0_2)
				(guard setLoop: 0 setCel: 0 setCycle: End self)
			)
			(3
				(proc0_3)
				(guard setScript: sSleeping)
				(= local0 0)
				(self dispose:)
			)
		)
	)
)

(instance sGuardSleeps of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(= local0 0)
				(proc0_14 620 3)
				(proc0_18 gLarry 620 4)
				(self cue:)
			)
			(1
				(proc0_18 The_Guard 620 5 108)
				(guard setLoop: 0 setCel: 0 setCycle: End self)
			)
			(2
				(guard setScript: sSleeping)
				(= local0 0)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance sGuardApproves of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(cond 
					(local1 (proc0_18 gLarry 620 6))
					(local2 (proc0_18 gLarry 620 7))
					(local3 (proc0_18 gLarry 620 8))
					(local4 (proc0_18 gLarry 620 9))
					(else (proc0_18 gLarry 620 10))
				)
				(self cue:)
			)
			(1
				(cond 
					((proc0_6 45)
						(proc0_18 The_Guard 620 11 108)
						(proc0_3)
						(guard setScript: sBackToSleep)
						(self dispose:)
					)
					(local1
						(proc0_18 The_Guard 620 12 108)
						(= local1 0)
						(proc0_10 6 118)
					)
					(local3
						(proc0_18 The_Guard 620 13 108)
						(= local3 0)
						(proc0_3)
						(guard setScript: sBackToSleep)
						(self dispose:)
					)
					(local2
						(proc0_18 The_Guard 620 14 108)
						(= local2 0)
						(proc0_10 6 119)
					)
					(local4
						(proc0_18 The_Guard 620 15 108)
						(= local4 0)
						(proc0_3)
						(guard setScript: sBackToSleep)
						(self dispose:)
					)
					(else (proc0_18 The_Guard 620 16 108) (proc0_7 48))
				)
				(self cue:)
			)
			(2
				(guard
					cycleSpeed: 12
					setLoop: 5
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(guard setLoop: 3 setCel: 0 setCycle: End self)
			)
			(4
				(guard
					setLoop: 4
					setCel: 0
					setCycle: ForwardCounter 2 self
				)
			)
			(5 (= seconds 2))
			(6
				(guard
					setLoop: 3
					setCel: (guard lastCel:)
					setCycle: Beg self
				)
			)
			(7
				(guard setLoop: 5 setCycle: End self)
			)
			(8
				(if (proc0_6 21)
					(proc0_18 The_Guard 620 17 108)
					(proc0_7 45)
					(proc0_3)
					(guard setScript: sBackToSleep)
					(self dispose:)
				else
					(proc0_18 The_Guard 620 18 108)
					(guard
						cycleSpeed: 18
						setLoop: 0
						setCel: 0
						setCycle: End self
					)
				)
			)
			(9
				(guard setScript: sSleeping)
				(= seconds 3)
			)
			(10
				(elevatorDing play:)
				(= cycles 10)
			)
			(11
				(elevator setCycle: End self)
				(elevatorLeft setCycle: End)
				(elevatorDoor play:)
			)
			(12
				(elevatorDoor stop:)
				(gLarry setMotion: MoveTo 96 146 self)
			)
			(13
				(gLarry setPri: 9 setMotion: MoveTo 58 136 self)
			)
			(14
				(gLarry setHeading: 180 self)
			)
			(15
				(elevatorDoor play:)
				(elevator setCycle: Beg self)
				(elevatorLeft setCycle: Beg)
			)
			(16
				(elevatorDoor stop:)
				(global2 newRoom: 640)
				(self dispose:)
			)
		)
	)
)

(instance sUsesBoard of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0)
				(gIconBar disable: 8)
				(gCast eachElementDo: #hide)
				(plant dispose:)
				(mural dispose:)
				(fStairs dispose:)
				(fLamp1 dispose:)
				(fLamp2 dispose:)
				(fAshtray dispose:)
				(sconceA dispose:)
				(sconceB dispose:)
				(clock dispose:)
				(breasts dispose:)
				(businessOne init:)
				(businessTwo init:)
				(businessThree init:)
				(businessFour init:)
				(businessFive init:)
				(businessSix init:)
				(businessSeven init:)
				(businessEight init:)
				(global2 drawPic: 630)
				(proc0_22 1)
				(Display
					620
					19
					dsCOORD
					86
					67
					dsCOLOR
					global128
					dsFONT
					global23
				)
				(Display
					620
					20
					dsCOORD
					88
					79
					dsCOLOR
					global128
					dsFONT
					global23
				)
				(Display
					620
					21
					dsCOORD
					88
					91
					dsCOLOR
					global128
					dsFONT
					global23
				)
				(Display
					620
					22
					dsCOORD
					89
					103
					dsCOLOR
					global128
					dsFONT
					global23
				)
				(Display
					620
					23
					dsCOORD
					90
					115
					dsCOLOR
					global128
					dsFONT
					global23
				)
				(Display
					620
					24
					dsCOORD
					90
					127
					dsCOLOR
					global128
					dsFONT
					global23
				)
				(Display
					620
					25
					dsCOORD
					92
					139
					dsCOLOR
					global128
					dsFONT
					global23
				)
				(Display
					620
					26
					dsCOORD
					93
					151
					dsCOLOR
					global128
					dsFONT
					global23
				)
				(board dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sReturnsFromBoard of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_3)
				(gIconBar enable: 8)
				(global2 drawPic: (global2 picture?))
				(gCast eachElementDo: #show)
				(businessOne dispose:)
				(businessTwo dispose:)
				(businessThree dispose:)
				(businessFour dispose:)
				(businessFive dispose:)
				(businessSix dispose:)
				(businessSeven dispose:)
				(businessEight dispose:)
				(plant init:)
				(mural init:)
				(fStairs init:)
				(fLamp1 init:)
				(fLamp2 init:)
				(fAshtray init:)
				(sconceA init:)
				(sconceB init:)
				(clock init:)
				(breasts init:)
				(board init: approachVerbs: 2 3 4)
				(proc0_22 0)
			)
		)
	)
)

(instance sBackToSleep of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 0)
				(guard setLoop: 0 setCel: 0 setCycle: End self)
			)
			(1 (guard setScript: sSleeping))
			(2 (self dispose:))
		)
	)
)

(instance sSleeping of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(guard
					setLoop: 1
					setCel: 0
					cycleSpeed: 30
					setCycle: End self
				)
			)
			(1 (= cycles 20))
			(2 (guard setCycle: Beg self))
			(3 (= cycles 20))
			(4 (self changeState: 0))
		)
	)
)

(instance guard of Prop
	(properties
		x 274
		y 124
		description {strážník}
		sightAngle 40
		approachX 244
		approachY 166
		view 622
		loop 1
		priority 11
		signal $4010
	)
	
	(method (init)
		(super init:)
		(self setScript: sSleeping)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(5
				(if (== local0 0)
					(guard setScript: sGuardWakes)
				else
					(ll5Timer dispose: delete:)
					(if (proc0_6 17)
						(global2 setScript: sGuardApproves)
					else
						(guard setScript: sGuardSleeps)
					)
				)
			)
			(4
				(if (== local0 1)
					(ll5Timer dispose: delete:)
					(switch param2
						(0
							(cond 
								((== ((Inv at: 0) state?) 1) (= local1 1) (global2 setScript: sGuardApproves))
								((== ((Inv at: 0) state?) 2) (= local3 1) (global2 setScript: sGuardApproves))
								(else
									(proc0_18 The_Guard 620 27 108)
									(guard setScript: sBackToSleep)
								)
							)
						)
						(3
							(= local2 1)
							(global2 setScript: sGuardApproves)
						)
						(7
							(= local4 1)
							(global2 setScript: sGuardApproves)
						)
						(else 
							(super doVerb: theVerb param2 &rest)
							(guard setScript: sBackToSleep)
						)
					)
				else
					(proc0_14 620 28)
				)
			)
			(2
				(if (== local0 0)
					(proc0_14 620 29)
				else
					(proc0_14 620 30)
				)
			)
			(3
				(if (== local0 1)
					(proc0_18 The_Guard 620 31 108)
				else
					(proc0_14 620 32)
				)
			)
			(10 (proc0_14 620 33))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance elevator of Prop
	(properties
		x 61
		y 148
		description {výtah}
		sightAngle 40
		view 620
		priority 8
		signal $4010
		cycleSpeed 12
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 620 34))
			(3 (proc0_14 620 35))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance elevatorLeft of Prop
	(properties
		x 45
		y 152
		description {výtah}
		sightAngle 40
		view 620
		loop 1
		priority 9
		signal $4010
		cycleSpeed 12
	)
	
	(method (doVerb theVerb param2)
		(elevator doVerb: theVerb param2 &rest)
	)
)

(instance elevatorDing of Sound
	(properties
		number 621
	)
)

(instance elevatorDoor of Sound
	(properties
		number 622
	)
)

(instance board of Feature
	(properties
		x 10
		y 131
		nsTop 98
		nsLeft 9
		nsBottom 165
		nsRight 38
		description {katalog budovy Shill}
		sightAngle 40
		approachX 61
		approachY 178
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(global2 setScript: sUsesBoard)
			)
			(3
				(global2 setScript: sUsesBoard)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance businessOne of Feature
	(properties
		x 157
		y 71
		nsTop 66
		nsLeft 93
		nsBottom 76
		nsRight 221
		description {katalog}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 620 36 67 -1 20))
			(1
				(global2 setScript: sReturnsFromBoard)
				1
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance businessTwo of Feature
	(properties
		x 156
		y 82
		nsTop 78
		nsLeft 92
		nsBottom 86
		nsRight 221
		description {katalog}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 620 37 67 -1 20))
			(1
				(global2 setScript: sReturnsFromBoard)
				1
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance businessThree of Feature
	(properties
		x 154
		y 94
		nsTop 90
		nsLeft 86
		nsBottom 99
		nsRight 223
		description {katalog}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 620 38 67 -1 20))
			(1
				(global2 setScript: sReturnsFromBoard)
				1
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance businessFour of Feature
	(properties
		x 153
		y 106
		nsTop 102
		nsLeft 85
		nsBottom 111
		nsRight 222
		description {katalog}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(proc0_7 17)
				(proc0_10 3 120)
				(proc0_14 620 39 67 -1 20)
			)
			(3
				(proc0_7 17)
				(proc0_10 3 120)
				(proc0_14 620 39 67 -1 20)
			)
			(1
				(global2 setScript: sReturnsFromBoard)
				1
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance businessFive of Feature
	(properties
		x 155
		y 118
		nsTop 114
		nsLeft 88
		nsBottom 123
		nsRight 222
		description {katalog}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 620 40 67 -1 20))
			(1
				(global2 setScript: sReturnsFromBoard)
				1
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance businessSix of Feature
	(properties
		x 155
		y 130
		nsTop 126
		nsLeft 87
		nsBottom 135
		nsRight 224
		description {katalog}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 620 41 67 -1 20))
			(1
				(global2 setScript: sReturnsFromBoard)
				1
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance businessSeven of Feature
	(properties
		x 156
		y 142
		nsTop 138
		nsLeft 89
		nsBottom 147
		nsRight 224
		description {katalog}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 620 42 67 -1 20))
			(1
				(global2 setScript: sReturnsFromBoard)
				1
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance businessEight of Feature
	(properties
		x 156
		y 154
		nsTop 150
		nsLeft 89
		nsBottom 159
		nsRight 223
		description {katalog}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 620 43 67 -1 20))
			(1
				(global2 setScript: sReturnsFromBoard)
				1
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance plant of Feature
	(properties
		x 120
		y 95
		nsTop 36
		nsLeft 104
		nsBottom 114
		nsRight 137
		description {rostlina}
		lookStr {Tato rostlina je zøejmì dobøe udržovaná, ale pro tvou misi je zbyteèná.}
	)
)

(instance mural of Feature
	(properties
		x 230
		y 47
		nsLeft 142
		nsBottom 95
		nsRight 319
		description {freska}
		lookStr {Je to docela zajímavá nástìnná malba.}
	)
)

(instance fStairs of Feature
	(properties
		x 229
		y 164
		nsTop 139
		nsLeft 139
		nsBottom 189
		nsRight 319
		description {schodištì}
		sightAngle 40
		onMeCheck $2000
		lookStr {Schodištì se vine vzhùru, ale sametový provaz pøes jeho spodní èást naznaèuje, že se nesmí používat pod hrozbou sankcí. Vypadá to, že výtah je tvoje jediná nadìje, Patti.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 620 44))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance fLamp1 of Feature
	(properties
		x 131
		y 163
		nsTop 139
		nsLeft 124
		nsBottom 188
		nsRight 138
		description {lampa}
		sightAngle 40
		lookStr {Nad schodištìm se tyèí krásná lampa ve stylu art deco.}
	)
)

(instance fLamp2 of Feature
	(properties
		x 294
		y 118
		nsTop 98
		nsLeft 287
		nsBottom 138
		nsRight 302
		description {lampa}
		sightAngle 40
		lookStr {Pìkná lampa ve stylu art deco se tyèí nad schodištìm.}
	)
)

(instance fAshtray of Feature
	(properties
		x 51
		y 150
		nsTop 141
		nsLeft 46
		nsBottom 160
		nsRight 56
		description {popelník}
		sightAngle 40
		approachX 70
		approachY 160
		lookStr {Popelník si peèlivì prohlížíš, jestli v nìm není diskotékový prùkaz, a na okamžik si myslíš, že hraješ "Leisure Suit Larry 1: In the Land of the Lounge Lizards". Samozøejmì, že nehraješ.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 620 45))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance sconceA of Feature
	(properties
		x 21
		y 81
		nsTop 77
		nsLeft 5
		nsBottom 86
		nsRight 37
		description {svícen}
		sightAngle 40
		lookStr {Jéje, budova Shill má vkusné svícny.}
	)
)

(instance sconceB of Feature
	(properties
		x 94
		y 71
		nsTop 69
		nsLeft 85
		nsBottom 74
		nsRight 103
		description {svícen}
		sightAngle 40
		lookStr {Jéje, v budovì Shillù jsou vkusné svícny.}
	)
)

(instance clock of Feature
	(properties
		x 230
		y 112
		nsTop 107
		nsLeft 215
		nsBottom 125
		nsRight 245
		description {hodiny}
		sightAngle 40
		lookStr {Na konci pultu ochranky jsou zabudovány krásné hodiny ve stylu Deco pro zamìstnance, kteøí jsou stále placeni od hodiny.}
	)
)

(instance breasts of Feature
	(properties
		x 191
		y 199
		z 80
		nsTop 34
		nsLeft 182
		nsBottom 44
		nsRight 201
		description {freska}
		sightAngle 40
		lookStr {Cože? Patti! Kdy ses zaèala zajímat o jiné ženy?}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 620 46))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance The_Guard of Talker
	(properties
		nsTop 15
		nsLeft 35
		view 1622
		loop 3
		viewInPrint 1
		name "The Guard"
	)
	
	(method (init)
		(= bust guardBust)
		(= eyes guardEyes)
		(= mouth guardMouth)
		(super init: &rest)
	)
)

(instance guardBust of Prop
	(properties
		view 1622
		loop 1
	)
)

(instance guardEyes of Prop
	(properties
		nsTop 32
		nsLeft 21
		view 1622
		loop 2
		cycleSpeed 70
	)
)

(instance guardMouth of Prop
	(properties
		nsTop 36
		nsLeft 15
		view 1622
		cycleSpeed 5
	)
)
