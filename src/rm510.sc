;;; Sierra Script 1.0 - (do not remove this comment)
(script# 510)
(include sci.sh)
(use Main)
(use LLRoom)
(use Door)
(use Class_255_0)
(use RTRandCycle)
(use PolyPath)
(use Polygon)
(use CueObj)
(use n958)
(use Sound)
(use Cycle)
(use InvI)
(use User)
(use PicView)
(use Obj)

(public
	rm510 0
)

(local
	local0
	[local1 3]
	local4
	local5
)
(instance rm510 of LLRoom
	(properties
		lookStr {V hale "Hard Disk Cafe" je k vidìní nesmírnì vzrušující (pro nerdy) vıstava starıch poèítaèovıch pamìtihodností. Pøi pouhém pohledu na tohle místo se ti zrychlí tep.}
		picture 510
		north 525
		south 500
	)
	
	(method (init)
		(proc958_0 128 515 512 513 514 511 510)
		(Load rsSOUND 510)
		(LDoor init: approachVerbs: 3)
		(switch gGNumber
			(north
				(gLarry edgeHit: 0 init: normalize:)
			)
			(535
				(proc0_3)
				(proc0_7 16)
				((Inv at: 14) state: 4)
				(gLarry
					x: (door approachX?)
					y: (door approachY?)
					init:
					normalize:
					edgeHit: 0
				)
			)
			(520
				(gLarry init: normalize: posn: 137 77)
				(if (gLarry has: 14)
					(proc0_2)
					(global2 setScript: sExitNorth)
				else
					(proc0_3)
				)
			)
			(500
				(gLarry init: normalize: posn: 334 219)
				(gLongSong fade: 127 10 10 0)
				(self setScript: sEnterSouth)
			)
			(else 
				(= global160 1)
				(if (not gGNumber)
					(WrapMusic firstSound: 500 lastSound: 502)
					(gLongSong
						number: 500
						play: WrapMusic
						flags: 1
						setLoop: 1
					)
				)
				(gLarry init: normalize: posn: 334 219)
				(self setScript: sEnterSouth)
			)
		)
		(door init:)
		(super init:)
		(if (and (!= gGNumber 535) (not (proc0_6 16)))
			(self
				addObstacle:
					((Polygon new:)
						type: 2
						init:
							0
							0
							319
							0
							319
							114
							270
							99
							258
							104
							245
							100
							251
							90
							238
							87
							218
							94
							208
							82
							218
							71
							215
							70
							210
							75
							172
							65
							169
							58
							146
							59
							147
							70
							106
							82
							81
							96
							92
							100
							98
							108
							84
							114
							62
							113
							50
							108
							29
							108
							4
							125
							6
							186
							270
							187
							272
							189
							0
							189
						yourself:
					)
			)
			(woman init: addToPic:)
			(womansMouth init: ignoreActors: 1 setScript: sMouth)
			(phone init: setCel: 1 stopUpd:)
		else
			(if (== gGNumber 535)
				(WrapMusic firstSound: 500 lastSound: 502)
				(gLongSong
					number: 500
					play: WrapMusic
					flags: 1
					setLoop: 1
				)
			)
			(self
				addObstacle:
					((Polygon new:)
						type: 2
						init:
							0
							0
							319
							0
							319
							114
							270
							99
							258
							104
							245
							100
							251
							90
							238
							87
							218
							94
							208
							82
							218
							71
							215
							70
							210
							75
							172
							65
							169
							58
							146
							59
							147
							70
							109
							83
							81
							96
							92
							100
							98
							108
							84
							114
							62
							113
							50
							108
							29
							108
							4
							125
							4
							187
							270
							187
							272
							189
							0
							189
						yourself:
					)
			)
			(phone init: setCel: 0 approachVerbs: 3 5 stopUpd:)
		)
		(if (== ((Inv at: 14) owner?) 510)
			(tape init: setCel: 255)
		)
		(if (== ((Inv at: 14) state?) 0)
			(Load rsSOUND 512 442)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: 2
					init: 50 168 44 161 52 156 149 157 157 163 145 169 77 169
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 69 129 80 124 131 124 141 130 130 135 79 135
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 120 110 129 103 173 103 186 109 179 114 173 117 126 117
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 142 147 140 141 148 135 201 135 213 143 204 150 188 152 159 152
					yourself:
				)
		)
		(musicBox init: approachVerbs: 3 4 stopUpd:)
		(maitreD init: approachVerbs: 5 3 4)
		(tapeReader init: approachVerbs: 3 4)
		(diskDrive init:)
		(pet init:)
		(appleII init:)
		(cashRegister init:)
		(monitor init:)
		(atari400 init:)
		(tapeDrive init:)
		(cactus1 init:)
		(cactus2 init:)
		(pianoRoll init:)
		(punchCardMachine init:)
		(podium init:)
		(desk init:)
		(bullBoard init:)
		(chair init:)
	)
	
	(method (doit)
		(super doit:)
		(if (and (gLarry mover?) gTheNewDialog)
			(gTheNewDialog dispose:)
		)
		(cond 
			(script)
			((proc0_5 gLarry 16) (proc0_2) (self setScript: sExitSouth))
		)
	)
	
	(method (newRoom newRoomNumber)
		(gLongSong fade: 127 10 10 0)
		(super newRoom: newRoomNumber)
	)
	
	(method (notify param1)
		(switch param1
			(-1 (proc0_14 510 0))
			(4668
				(if (not (proc0_6 1))
					(proc0_7 1)
					(proc0_10 2 110)
					(proc0_14 510 1)
					(proc0_18 gLarry 510 2)
					(proc0_14 510 3)
				else
					(proc0_14 510 4)
				)
			)
			(else  (proc0_14 510 5))
		)
	)
)

(instance sExitNorth of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLarry
					setMotion: PolyPath (door approachX?) (door approachY?) self
				)
			)
			(1
				(door locked: 0 exitType: 0 open:)
			)
		)
	)
)

(instance sEnterSouth of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry setMotion: MoveTo 293 183 self)
			)
			(1
				(proc0_3)
				(gLarry normalize:)
				(self dispose:)
			)
		)
	)
)

(instance sBribe of Script
	(properties)
	
	(method (changeState newState &tmp temp0 [temp1 30])
		(switch (= state newState)
			(0
				(proc0_18 gLarry 510 6)
				(= ticks 60)
			)
			(1
				(cond 
					((== ((Inv at: 14) state?) 0) (proc0_18 the_maitre_d_ 510 7 108 139 self))
					((== ((Inv at: 14) state?) 4)
						(proc0_18 the_maitre_d_ 510 8 108)
						(proc0_3)
						(self dispose:)
					)
					(else
						(proc0_18 the_maitre_d_ 510 9 108)
						(proc0_3)
						(self dispose:)
					)
				)
			)
			(2 (= ticks 67))
			(3
				(= temp0 0)
				(while (< temp0 1)
					(= temp1 0)
					(proc255_2
						@temp1
						6
						{Jak moc si pøeješ vrchnícho podplatit?}
						80
						{Pìknì namazat dlaò}
					)
					(= temp0 (ReadNumber @temp1))
				)
				(if (> temp0 99)
					(proc0_2)
					(proc0_10 3 106)
					(gLarry put: 12)
					(proc0_18 the_maitre_d_ 510 10 108)
					(= local4 1)
					((Inv at: 14) state: 1)
					(global2 setScript: sMD)
				else
					(proc0_18 the_maitre_d_ 510 11 108)
					(proc0_3)
					(self dispose:)
				)
			)
		)
	)
)

(instance sMouth of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(womansMouth setCycle: Fwd cycleSpeed: (Random 6 12))
				(= cycles (Random 48 90))
			)
			(1
				(womansMouth setCel: 0)
				(= cycles (Random 30 60))
			)
			(2 (self init:))
		)
	)
)

(instance sMusicBox of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(musicBox setCycle: Fwd)
				(musicBoxCloseUp init: setCycle: Fwd)
				(= seconds 3)
			)
			(1
				(proc0_10 12 107)
				(proc0_14 510 12 67 100 10)
				(= seconds 3)
			)
			(2
				(musicBoxCloseUp dispose:)
				(musicBox setCel: 0 stopUpd:)
				(proc0_3)
				(gLarry normalize:)
				(self dispose:)
			)
		)
	)
)

(instance sPhone of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry
					view: 511
					posn: (- (gLarry x?) 10) (gLarry y?)
					setLoop: 2
					setCel: 0
					setCycle: CT 4 1 self
				)
			)
			(1
				(phone setCel: 1)
				(gLarry setCycle: End self)
			)
			(2
				(User canInput: 1)
				((ScriptID 20 0) init: 1 self)
			)
			(3
				(gLarry setCycle: CT 4 -1 self)
			)
			(4
				(phone setCel: 0 stopUpd:)
				(gLarry setCycle: Beg self)
			)
			(5
				(gLarry
					normalize: 550
					posn: (+ (gLarry x?) 10) (gLarry y?)
				)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance sExitSouth of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gLarry
					setMotion: MoveTo (+ (gLarry x?) 40) (+ (gLarry y?) 40) self
				)
			)
			(1 (global2 newRoom: 500))
		)
	)
)

(instance sMD of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry setHeading: 270 self)
			)
			(1
				(if local4 (= state 19))
				(= cycles 2)
			)
			(2
				(cond 
					((== ((Inv at: 14) state?) 0)
						(switch (++ local0)
							(1 (proc0_18 gLarry 510 13))
							(2 (proc0_18 gLarry 510 14))
							(3 (proc0_18 gLarry 510 15))
							(4 (proc0_18 gLarry 510 16))
							(5 (proc0_18 gLarry 510 17))
							(6 (proc0_18 gLarry 510 18))
							(7 (proc0_18 gLarry 510 19))
							(8 (proc0_18 gLarry 510 20))
							(9 (proc0_18 gLarry 510 21))
							(else  (proc0_18 gLarry 510 22))
						)
					)
					((== ((Inv at: 14) owner?) 510) (proc0_18 gLarry 510 23))
					((== ((Inv at: 14) state?) 4) (proc0_18 gLarry 510 24))
					((proc0_6 2) (proc0_18 gLarry 510 25))
					((== ((Inv at: 14) state?) 1) (proc0_18 gLarry 510 26))
				)
				(= cycles 3)
			)
			(3
				(cond 
					((== ((Inv at: 14) state?) 0)
						(switch local0
							(1
								(proc0_18 the_maitre_d_ 510 27 108)
							)
							(2
								(proc0_18 the_maitre_d_ 510 27 108)
							)
							(3
								(proc0_18 the_maitre_d_ 510 27 108)
							)
							(4
								(proc0_18 the_maitre_d_ 510 27 108)
							)
							(5
								(proc0_18 the_maitre_d_ 510 28 108)
							)
							(6
								(proc0_18 the_maitre_d_ 510 29 108)
							)
							(7
								(proc0_18 the_maitre_d_ 510 30 108)
							)
							(8
								(proc0_18 the_maitre_d_ 510 31 108)
							)
							(9
								(proc0_18 the_maitre_d_ 510 32 108 139 self)
								(= local4 1)
								((Inv at: 14) state: 1)
							)
							(else 
								(proc0_18 the_maitre_d_ 510 33 108)
							)
						)
					)
					((== ((Inv at: 14) owner?) 510) (proc0_18 the_maitre_d_ 510 34 108))
					((== ((Inv at: 14) state?) 4) (proc0_18 the_maitre_d_ 510 8 108))
					((proc0_6 2) (global2 setScript: sDoubleTalk))
					((== ((Inv at: 14) state?) 1) (proc0_18 the_maitre_d_ 510 35 108))
				)
				(if (not local4) (proc0_3) (self dispose:))
			)
			(4
				(= state 19)
				(= cycles 2)
				(proc0_10 3 106)
				(proc0_14 510 36 67 -1 185)
			)
			(20
				(maitreD
					init:
					view: 515
					setCycle: Walk
					setLoop: -1
					ignoreActors: 1
					illegalBits: 0
					setMotion: MoveTo 133 86 self
				)
				(gLarry setMotion: MoveTo 153 (gLarry y?))
				(= local4 0)
			)
			(21
				(typingFX play:)
				(maitreD view: 512 setLoop: 1 setCycle: Fwd)
				(screen init:)
				(gLarry setMotion: 0 setHeading: 315)
				(= seconds 3)
			)
			(22
				(typingFX stop:)
				(maitreD setCel: 0)
				(screen setCycle: Fwd)
				(= seconds 3)
			)
			(23
				(typingFX play:)
				(maitreD setCycle: Fwd)
				(screen setCel: 0)
				(= seconds 3)
			)
			(24
				(typingFX stop:)
				(maitreD setCel: 0)
				(tape init: setCycle: End self)
				(screen dispose:)
			)
			(25
				(proc0_18 the_maitre_d_ 510 37 108 139 self)
			)
			(26
				(maitreD
					view: 515
					setCycle: Walk
					setLoop: -1
					setMotion: MoveTo 70 90 self
				)
			)
			(27
				(maitreD view: 512 setLoop: 0)
				((Inv at: 14) owner: 510)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance sDoubleTalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_18 the_maitre_d_ 510 38 108 139 self)
			)
			(1
				(proc0_18 the_maitre_d_ 510 39 108)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance sGetTape of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLarry
					view: 511
					setCel: 0
					setLoop: 0
					cycleSpeed: 6
					setCycle: CT 6 1 self
					get: 14
				)
			)
			(1
				(paperRip play:)
				(gLarry setCycle: End self)
				(tape dispose:)
			)
			(2
				(gLarry setLoop: 1 normalize:)
				(proc0_10 4 109)
				(proc0_14 510 40)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance phone of View
	(properties
		x 59
		y 105
		z 20
		nsTop 71
		nsLeft 50
		nsBottom 85
		nsRight 72
		description {telefon}
		sightAngle 90
		approachX 81
		approachY 96
		view 510
		loop 4
		priority 5
		signal $5810
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(if (proc0_6 16)
					(proc0_14 510 41)
				else
					(proc0_14 510 42)
				)
			)
			(5 (self doVerb: 3 &rest))
			(3
				(cond 
					((proc0_6 1) (proc0_14 510 43))
					((proc0_6 16) (global2 setScript: sPhone))
					(else (proc0_18 gLarry 510 44) (proc0_14 510 45))
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance screen of Prop
	(properties
		x 123
		y 46
		nsTop 40
		nsLeft 110
		nsBottom 49
		nsRight 130
		description {poèítaèovı terminál}
		sightAngle 90
		view 510
		loop 2
		priority 15
		signal $5810
	)
)

(instance woman of View
	(properties
		x 80
		y 106
		description {Berta}
		lookStr {Velká agresivní ena mluví do telefonu po celou dobu, co jsi tady.}
		view 513
		priority 7
		signal $5810
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(3
				(proc0_18 gLarry 510 44)
				(proc0_14 510 46)
			)
			(5
				(proc0_18 gLarry 510 47)
				(proc0_14 510 46)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance womansMouth of Prop
	(properties
		x 74
		y 75
		description {Bertina hlava}
		view 513
		loop 1
		priority 7
		signal $5810
	)
)

(instance musicBox of Prop
	(properties
		x 39
		y 189
		nsTop 173
		nsLeft 19
		nsBottom 189
		nsRight 72
		description {hudební skøíòka}
		approachX 58
		approachY 186
		view 514
		priority 15
		signal $4810
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(proc0_14 510 48)
				(if (gLarry has: 14)
					(proc0_14 510 49 67 -1 185)
				else
					(proc0_14 510 50)
				)
			)
			(3
				(musicBoxFX play: self)
				(gLongSong fade: 80 10 10 0)
				(proc0_14 510 51 67 100 10)
			)
			(5 (proc0_14 510 52))
			(4
				(switch param2
					(14
						(if (not (> ((Inv at: 14) state?) 1))
							(gLongSong fade: 80 10 10 0)
							(musicBoxFX play: self)
							((Inv at: 14) state: 3)
							(proc0_14 510 53)
							(global2 setScript: sMusicBox)
						else
							(proc0_14 510 54)
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
	
	(method (cue)
		(super cue:)
		(gLongSong fade: 127 10 10 0)
	)
)

(instance musicBoxCloseUp of Prop
	(properties
		x 71
		y 174
		view 511
		loop 1
		priority 15
		signal $4810
	)
)

(instance tape of Prop
	(properties
		x 112
		y 59
		description {vaše èlenská páska}
		sightAngle 90
		approachX 117
		approachY 82
		lookStr {Èlenská páska, kterou jsi tak moc chtìl, teï bezvládnì visí ze strany èteèky papírovıch pásek a pomalu a línì se kroutí ve vìtru.}
		view 510
		loop 3
		priority 3
		signal $4010
	)
	
	(method (init)
		(super init:)
		(self approachVerbs: 3 4)
		(tapeReader approachX: approachX approachY: approachY)
	)
	
	(method (dispose)
		(super dispose:)
		(tapeReader approachX: 139 approachY: 77)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(proc0_2)
				(global2 setScript: sGetTape)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance maitreD of Actor
	(properties
		x 70
		y 90
		description {vrchní}
		approachX 103
		approachY 89
		lookStr {Tìm, kteøí se umí tváøit hloupì a zároveò povıšenì, docela závidíš.}
		view 512
		priority 4
		signal $4810
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(proc0_18 gLarry 510 56)
				(if (gLarry has: 14)
					(proc0_18 the_maitre_d_ 510 57 108)
				else
					(proc0_18 the_maitre_d_ 510 58 108)
				)
			)
			(5 (global2 setScript: sMD))
			(4
				(if (== ((Inv at: 14) owner?) 510)
					(proc0_18 the_maitre_d_ 510 59 108)
				else
					(switch param2
						(12
							(proc0_2)
							(global2 setScript: sBribe)
						)
						(13
							(if (== ((Inv at: 14) state?) 1)
								(proc0_18 gLarry 510 60)
								(proc0_18 the_maitre_d_ 510 61 108)
								(proc0_10 5 108)
								((Inv at: 14) state: 2)
								(gLarry put: 13)
								(= local4 1)
								(global2 setScript: sMD)
							else
								(proc0_18 the_maitre_d_ 510 62 108)
							)
						)
						(6
							(proc0_18 gLarry 510 63)
							(proc0_18 the_maitre_d_ 510 64 108 139 self)
							(gLarry put: 6 gNumber)
							(gIconBar disable: 6 curIcon: (gIconBar at: 0))
							(gGame setCursor: ((gIconBar curIcon?) cursor?))
						)
						(11
							(proc0_18 gLarry 510 65)
							(proc0_18 the_maitre_d_ 510 66 108)
						)
						(else 
							(super doVerb: theVerb param2 &rest)
						)
					)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (cue)
		(super cue:)
		(proc0_14 510 55 67 -1 185)
	)
)

(instance LDoor of Prop
	(properties
		x 139
		y 66
		description {køídlové dveøe}
		approachX 165
		approachY 70
		view 510
		priority 2
		signal $0810
	)
	
	(method (doVerb theVerb param2)
		(door doVerb: theVerb param2)
	)
)

(instance door of Door
	(properties
		x 179
		y 63
		heading 180
		nsTop 8
		nsLeft 141
		nsBottom 63
		nsRight 177
		description {køídlové dveøe}
		approachX 165
		approachY 70
		lookStr {Pøedpokládáš, e tyhle dveøe vedou do samotné kavárny.}
		view 510
		loop 1
		priority 2
		signal $0010
		entranceTo 525
		locked 1
		moveToX 156
		moveToY 60
		enterType 0
		exitType 0
	)
	
	(method (init)
		(= doubleDoor LDoor)
		(super init:)
		(self approachVerbs: 3)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 510 67))
			(4
				(switch param2
					(14 (proc0_14 510 68))
					(7 (proc0_14 510 69))
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

(instance the_maitre_d_ of Talker
	(properties
		nsTop 33
		nsLeft 22
		view 1512
		loop 3
		viewInPrint 1
		name "maitre d'"
	)
	
	(method (init)
		(= bust talkerBust)
		(= eyes talkerEyes)
		(= mouth talkerMouth)
		(super init:)
	)
)

(instance talkerBust of View
	(properties
		view 1512
		loop 1
	)
)

(instance talkerEyes of Prop
	(properties
		nsTop 11
		nsLeft 26
		view 1512
		loop 2
		cycleSpeed 30
	)
)

(instance talkerMouth of Prop
	(properties
		nsTop 24
		nsLeft 12
		view 1512
	)
)

(instance tapeReader of Feature
	(properties
		x 112
		y 65
		nsTop 38
		nsLeft 101
		nsBottom 73
		nsRight 139
		description {stroj na papírové pásky}
		sightAngle 180
		approachX 139
		approachY 77
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(proc0_14 510 70)
				(if (== ((Inv at: 14) owner?) 510) (proc0_14 510 71))
			)
			(3
				(if (== ((Inv at: 14) owner?) 510)
					(tape doVerb: 3)
				else
					(global2 newRoom: 520)
				)
			)
			(5 (proc0_14 510 72))
			(4
				(switch param2
					(14
						(proc0_7 14)
						(global2 newRoom: 520)
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

(instance diskDrive of Feature
	(properties
		x 301
		y 82
		nsTop 56
		nsLeft 283
		nsBottom 108
		nsRight 319
		description {staroitná disková jednotka}
		sightAngle 90
		lookStr {Tato raná disková jednotka byla velká jako praèka a pojmula obrovské mnoství dat - více ne jeden megabyte.}
	)
	
	(method (doVerb theVerb param2)
		(if (!= theVerb 2)
			(proc0_14 510 73)
		else
			(super doVerb: theVerb param2)
		)
	)
)

(instance pet of Feature
	(properties
		x 108
		y 102
		nsTop 92
		nsLeft 89
		nsBottom 113
		nsRight 128
		description {Pet Computer}
		sightAngle 90
		onMeCheck $0002
		lookStr {Pet Computer jsi nevidìl od prvních dnù "InfoWorldu"!}
	)
	
	(method (doVerb theVerb param2)
		(if (!= theVerb 2)
			(proc0_14 510 74)
		else
			(super doVerb: theVerb param2)
		)
	)
)

(instance appleII of Feature
	(properties
		x 173
		y 112
		nsTop 101
		nsLeft 154
		nsBottom 124
		nsRight 192
		description {poèítaè Apple II}
		sightAngle 90
		onMeCheck $0002
		lookStr {První poèítaèové zuby jsi si vylámal na starém poèítaèi Apple II s Integer BASICem. Nebyl to ani model Plus!}
	)
	
	(method (doVerb theVerb param2)
		(if (!= theVerb 2)
			(proc0_14 510 74)
		else
			(super doVerb: theVerb param2)
		)
	)
)

(instance cashRegister of Feature
	(properties
		x 148
		y 89
		nsTop 78
		nsLeft 128
		nsBottom 100
		nsRight 169
		description {pokladna}
		sightAngle 90
		onMeCheck $0002
		lookStr {Tento miláèek spoleènosti NCR byl jednou z prvních pokladen øízenıch mikroprocesorem.}
	)
	
	(method (doVerb theVerb param2)
		(if (!= theVerb 2)
			(proc0_14 510 74)
		else
			(super doVerb: theVerb param2)
		)
	)
)

(instance monitor of Feature
	(properties
		x 124
		y 135
		nsTop 126
		nsLeft 111
		nsBottom 144
		nsRight 138
		description {monitor se zelenou obrazovkou}
		sightAngle 90
		onMeCheck $0002
		lookStr {Tento starobylı pøístroj dokázal zobrazit text v jakékoliv barvì, pokud byl zelenı na èerném pozadí.}
	)
	
	(method (doVerb theVerb param2)
		(if (!= theVerb 2)
			(proc0_14 510 74)
		else
			(super doVerb: theVerb param2)
		)
	)
)

(instance atari400 of Feature
	(properties
		x 78
		y 144
		nsTop 137
		nsLeft 58
		nsBottom 152
		nsRight 99
		description {poèítaè Atari 400}
		sightAngle 90
		onMeCheck $0002
		lookStr {Kámo, to Atari 400 v tobì vyvolává pøíjemné vzpomínky na tvé špatnì strávené mládí, kdy jsi hrál "Froggera", zatímco tví spoluáci randili!}
	)
	
	(method (doVerb theVerb param2)
		(if (!= theVerb 2)
			(proc0_14 510 74)
		else
			(super doVerb: theVerb param2)
		)
	)
)

(instance tapeDrive of Feature
	(properties
		x 16
		y 71
		nsTop 40
		nsBottom 103
		nsRight 32
		description {staroitná pásková mechanika}
		sightAngle 90
		lookStr {Jedná se o jednu z prvních páskovıch mechanik na svìtì, ve své dobì revoluèní, dnes se zdá bıt neuvìøitelnì kuriózní. Vdy by se na ni nevešel ani "Space Quest", nato "King's Quest"!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(4
				(switch param2
					(14 (proc0_14 510 75))
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

(instance pianoRoll of Feature
	(properties
		x 243
		y 17
		nsTop 9
		nsLeft 220
		nsBottom 26
		nsRight 266
		description {klavírní válec}
		sightAngle 90
		lookStr {Pianola byla ranım vyuitím dìrovanıch otvorù k ovládání mechanického zaøízení. Do kovové tyèe bylo vyraenou 88 otvorù, pøièem kadı otvor pøedstavoval jinı tón. Podle toho, kde se pak na pohybujícím se papíru objevily otvory, byly pøehrány odpovídající tóny.}
	)
	
	(method (doVerb)
		(proc0_14 510 76)
	)
)

(instance punchCardMachine of Feature
	(properties
		x 253
		y 61
		nsTop 34
		nsLeft 222
		nsBottom 88
		nsRight 284
		description {stroj na dìrné štítky}
		sightAngle 40
		lookStr {Tato èteèka dìrnıch štítkù pochází ze sèítání lidu v USA v roce 1890. Dokázala zpracovat a 80 znakù nebo sloupcù dat, co je èíslo, které dodnes zùstává šíøkou vìtšiny poèítaèovıch zobrazovacích zaøízení.}
	)
	
	(method (doVerb)
		(proc0_14 510 77)
	)
)

(instance chair of Feature
	(properties
		x 39
		y 84
		nsTop 65
		nsLeft 28
		nsBottom 103
		nsRight 51
		description {idle}
		sightAngle 40
		lookStr {Tahle idle je urèená vıhradnì pro vrchního.}
	)
)

(instance bullBoard of Feature
	(properties
		x 25
		y 31
		nsTop 6
		nsBottom 56
		nsRight 51
		description {nástìnka}
		sightAngle 40
		lookStr {Na nástìnce jsou fotografie slavnıch nerdù, kteøí sem èasto chodí!}
	)
)

(instance podium of Feature
	(properties
		x 78
		y 95
		nsTop 50
		nsLeft 55
		nsBottom 95
		nsRight 102
		description {pódium vrchního}
		sightAngle 40
		onMeCheck $0002
		lookStr {Pódium vrchního je tak akorát velké, aby se za nìj mohl schovat, kdy po nìm dav zaène házet vìci!}
	)
)

(instance desk of Feature
	(properties
		x 61
		y 99
		nsTop 79
		nsLeft 46
		nsBottom 106
		nsRight 76
		description {stùl}
		sightAngle 40
		lookStr {Pøál by sis mít takovı pìknı stùl ve své mizerné kanceláøi.}
	)
)

(instance cactus1 of Feature
	(properties
		x 203
		y 40
		nsTop 16
		nsLeft 190
		nsBottom 65
		nsRight 217
		description {kaktus}
		sightAngle 40
		onMeCheck $0004
		lookStr {Kaktus je pokrytı ostrımi trny. (Proto kaktusy píchají, no ne?)}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_18 gLarry 510 78))
			(5 (proc0_14 510 79))
			(4
				(switch param2
					(14 (proc0_14 510 80))
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

(instance cactus2 of Feature
	(properties
		x 116
		y 157
		nsTop 125
		nsLeft 79
		nsBottom 189
		nsRight 154
		description {kaktus}
		sightAngle 40
		onMeCheck $0004
	)
	
	(method (doVerb)
		(cactus1 doVerb: &rest)
	)
)

(instance musicBoxFX of Sound
	(properties
		flags $0001
		number 510
	)
)

(instance typingFX of Sound
	(properties
		flags $0001
		number 442
		loop -1
	)
)

(instance paperRip of Sound
	(properties
		flags $0001
		number 512
	)
)
